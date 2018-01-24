package junggate.realestate

import junggate.realestate.jpa.model.Feed
import junggate.realestate.jpa.repository.BlogRepository
import junggate.realestate.jpa.service.BlogService
import junggate.realestate.jpa.service.FeedService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import java.util.*

@SpringBootApplication
class RealestateApplication

fun main(args: Array<String>) {
    val context = SpringApplication.run(RealestateApplication::class.java, *args)
    test_blog(context)
    test_feed(context)
}


fun test_blog(context: ConfigurableApplicationContext) {
    val service = context.getBean(BlogService::class.java)

    //Test Insert
    service.insertBlog("aaa")

    //Teet Update
    service.updateBlogCurrentTime("aaa")
}


fun test_feed(context: ConfigurableApplicationContext) {
    val serviceFeed = context.getBean(FeedService::class.java)
    val serviceBlog = context.getBean(BlogService::class.java)
    val blog = serviceBlog.findByUrl("aaa").first()

    var feed = Feed()
    feed.author = "aut"
    feed.category = "cat"
    feed.blog = blog

    //Test Insert
    serviceFeed.insertFeed(feed)
}