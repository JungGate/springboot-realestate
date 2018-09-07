package junggate.realestate.controller

import com.mitchellbosecke.pebble.PebbleEngine
import junggate.realestate.component.RssComponent
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.service.PostService
import junggate.realestate.jpa.service.RssService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import java.io.StringWriter

@Controller
class PostController{
    private val engin = PebbleEngine.Builder().build()

    @Autowired
    private lateinit var postService: PostService

    //localjost:8080/post/data?page=0&size=10&sort=ename,desc
    @RequestMapping("/post/data")
    @ResponseBody
    fun select_post(model:Model, pageable: Pageable) : Page<Post>? {
        return postService.findAll(pageable = pageable)
    }

}