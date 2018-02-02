package junggate.realestate.controller

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.service.BlogService
import junggate.realestate.jpa.service.PostService
import junggate.realestate.jpa.service.RssService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class DBSelectController(){
    @Autowired
    private lateinit var rssService: RssService

    @Autowired
    private lateinit var blogService: BlogService

    @Autowired
    private lateinit var postService: PostService

    @RequestMapping("select_rss")
    @ResponseBody
    fun select_rss() : List<Rss>{
        val list = rssService.findAll()
        return list
    }

    @RequestMapping("select_blog")
    @ResponseBody
    fun select_blog() : List<Blog>{
        val list = blogService.findAll()
        return list
    }
    @RequestMapping("select_post")
    @ResponseBody
    fun select_list() : List<Post>{
        val list = postService.findAll()
        return list
    }
}