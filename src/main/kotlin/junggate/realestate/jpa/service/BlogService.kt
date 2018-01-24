package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.repository.BlogRepository
import junggate.realestate.util.DateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.text.SimpleDateFormat
import java.util.*

@Service
class BlogService @Autowired constructor(private val blogRepository: BlogRepository){


    fun insertBlog(url:String){
        var blog= Blog()
        blog.url= url
        blogRepository.save(blog)
        println("insertBlog")
    }

    fun updateBlogCurrentTime(url:String) {
        blogRepository.updateLastUpdateDate(url, DateUtil.getCurrentDate())
    }


}