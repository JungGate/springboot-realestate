package junggate.realestate

import junggate.realestate.jpa.repository.BlogRepository
import junggate.realestate.jpa.service.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import java.util.*

@SpringBootApplication
class RealestateApplication

fun main(args: Array<String>) {
    val context = SpringApplication.run(RealestateApplication::class.java, *args)
    test_db(context)
}


fun test_db(context: ConfigurableApplicationContext) {
    val service = context.getBean(BlogService::class.java)

    //Test Insert
    service.insertBlog("aaa")

    //Teet Update
    service.updateBlogCurrentTime("aaa")
}