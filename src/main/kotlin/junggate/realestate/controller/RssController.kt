package junggate.realestate.controller

import com.mitchellbosecke.pebble.PebbleEngine
import junggate.realestate.component.RssComponent
import junggate.realestate.jpa.model.Rss
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
class RssController{
    private val engin = PebbleEngine.Builder().build()

    @Autowired
    private lateinit var rssService: RssService

//    @GetMapping("/rss")
//    @ResponseBody
//    fun index() : String {
//        val compiledTemplate = engin.getTemplate("templates/rss.html")
//        val writer = StringWriter()
//
//        val list = rssService.findAll()
//
//        val context = HashMap<String, Any>()
//
//        context.put("list_count", list.count())
//        context.put("list", list.map { hashMapOf("init_date" to it.initUpdateDate, "url" to it.url) })
//        compiledTemplate.evaluate(writer, context )
//
//        val output = writer.toString()
//
//        print("output : ${output}")
//        return output
//    }

    @RequestMapping("/rss/data")
    @ResponseBody
    fun select_rss() : List<Rss>{
        val list = rssService.findAll()
        return list
    }

}