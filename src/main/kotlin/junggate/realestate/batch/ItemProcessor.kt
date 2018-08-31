package junggate.realestate.batch

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Component
import org.springframework.batch.item.ItemProcessor
import java.net.URL

@Component
class ItemProcessor : ItemProcessor<String, SyndFeed> {
    override fun process(item:String): SyndFeed?{
        println("[processor]$item")
        val feed = SyndFeedInput().build(XmlReader(URL(item)))
        feed.uri = item
        return feed
    }
}