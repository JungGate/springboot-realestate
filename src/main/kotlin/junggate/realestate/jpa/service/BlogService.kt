package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.repository.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlogService @Autowired constructor(private val blogRepository: BlogRepository){
    fun findAll(): MutableList<Blog>{
        return blogRepository.findAll()
    }

    fun insertBlog(blog: Blog){
        blogRepository.save(blog)
    }
}