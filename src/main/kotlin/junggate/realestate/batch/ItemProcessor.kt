package junggate.realestate.batch

import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Component
import org.springframework.batch.item.ItemProcessor
import java.net.URL

@Component
open class ItemProcessor:ItemProcessor<String, String>{
    override fun process(item:String):String{
        println("[processor]$item")

        val url = "http://blog.rss.naver.com/iles1026.xml"
        val feed = SyndFeedInput().build(XmlReader(URL(url)))

        var resultString = "title:${feed.title}, author:${feed.author}"

        println("[processor] $resultString")

        return item
    }
}