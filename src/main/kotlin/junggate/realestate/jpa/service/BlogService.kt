package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.repository.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FeedService @Autowired constructor(private val blogRepository: BlogRepository){
    fun insertFeed(blog: Blog){
        blogRepository.save(blog)
        println("insertBlog")
    }

}