package junggate.realestate.controller

import com.mitchellbosecke.pebble.PebbleEngine
import junggate.realestate.component.RssComponent
import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.service.BlogService
import junggate.realestate.jpa.service.PostService
import junggate.realestate.jpa.service.RssService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import java.io.StringWriter

@Controller
class BlogController{
    private val engin = PebbleEngine.Builder().build()

    @Autowired
    private lateinit var blogService: BlogService

    @RequestMapping("/blog/data")
    @ResponseBody
    fun select_post() : List<Blog>{
        val list = blogService.findAll()
        println("Post Data : ${list.count()}")
        return list
    }

}