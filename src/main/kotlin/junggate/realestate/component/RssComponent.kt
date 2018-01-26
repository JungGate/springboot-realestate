package junggate.realestate.component

import com.rometools.rome.feed.synd.SyndFeedImpl
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Component
import java.net.URL

@Component
class RssComponent{
    companion object {
        fun request(rssUrl: String) : SyndFeedImpl{
            val feed: SyndFeedImpl = SyndFeedInput().build(XmlReader(URL(rssUrl))) as SyndFeedImpl
            println("RssComponent.request: $rssUrl")
            return feed
        }
    }

}