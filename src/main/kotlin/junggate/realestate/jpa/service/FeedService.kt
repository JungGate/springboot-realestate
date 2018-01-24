package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Feed
import junggate.realestate.jpa.repository.BlogRepository
import junggate.realestate.jpa.repository.FeedRepository
import junggate.realestate.util.DateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FeedService @Autowired constructor(private val feedRepository: FeedRepository){
    fun insertFeed(feed:Feed){
        feedRepository.save(feed)
        println("insertBlog")
    }

}