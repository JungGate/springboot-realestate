package junggate.realestate.batch

import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.service.RssService
import org.springframework.stereotype.Component
import org.springframework.batch.item.ItemReader
import org.springframework.beans.factory.annotation.Autowired

@Component
class ItemReader(@Autowired private var rssService: RssService) :ItemReader<String>{
    private var index = 0
    private var rssList:List<Rss> = arrayListOf()

    override fun read():String?{
        if (rssList.size == 0){
            rssList = rssService.findAll()
        }

        if(rssList.size <= index)
            return null

        val rss = rssList[index]
        println("[reader] $index(${rssList.size} = ${rss.url})")

        index++

        return rss.url
    }
}