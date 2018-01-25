package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.repository.RssRepository
import junggate.realestate.util.DateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RssService @Autowired constructor(private val rssRepository: RssRepository){
    fun findByUrl(url:String): MutableList<Rss>{
        return rssRepository.findByUrl(url)
    }

    fun insertRssUrl(url:String){
        var rss = Rss()
        rss.url= url
        rssRepository.save(rss)
    }

    fun updateRss(rss:Rss){
        rssRepository.save(rss)
    }
    fun updateBlogCurrentTime(url:String) {
        rssRepository.updateLastUpdateDate(url, DateUtil.getCurrentDate())
    }


}