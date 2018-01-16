package junggate.realestate.business

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.feed.synd.SyndFeedImpl
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
class RssBlogRequest{
    @RequestMapping("rss/read")
    fun request_rss_read(@RequestParam(value = "name", defaultValue = "http://blog.rss.naver.com/iles1026.xml")url:String) : String{

        val feed = requestBlogInfo(url)
        return  "{\"title\" : \"${feed.title}\"}"
    }


    fun requestBlogInfo(blogUrl:String) : SyndFeedImpl{
//        val url = "http://blog.rss.naver.com/iles1026.xml"
        val feed:SyndFeedImpl = SyndFeedInput().build(XmlReader(URL(blogUrl))) as SyndFeedImpl

        var resultString = "title:${feed.title}, author:${feed.author}"
        println("[processor] $resultString")

        return feed
    }
}