package junggate.realestate.controller

import com.mitchellbosecke.pebble.PebbleEngine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.StringWriter

@Controller
class IndexController{
    private val engin = PebbleEngine.Builder().build()

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    @GetMapping("/")
    fun index() : String {
        return "index"
    }

//    fun index() : String {
//        val compiledTemplate = engin.getTemplate("templates/index_.html")
//
//        val writer = StringWriter()
//        val context = HashMap<String, Any>()
//        context.put("websiteTitle", "My First Website")
//
//
//        val contents: MutableList<Map<String, String>> = ArrayList()
//        contents.add(hashMapOf("title" to "title1", "content" to "content1"))
//        contents.add(hashMapOf("title" to "title2", "content" to "content2"))
//        contents.add(hashMapOf("title" to "title3", "content" to "content3"))
//
//        context.put("contents", contents)
//
//        compiledTemplate.evaluate(writer, context)
//
//        val output = writer.toString()
//
//        print("output : ${output}")
//        return output
//    }

}