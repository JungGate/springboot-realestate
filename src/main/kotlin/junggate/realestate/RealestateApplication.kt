package junggate.realestate

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.service.RssService
import junggate.realestate.jpa.service.BlogService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class RealestateApplication

fun main(args: Array<String>) {
    val context = SpringApplication.run(RealestateApplication::class.java, *args)
    test_blog(context)
    test_feed(context)
}


fun test_blog(context: ConfigurableApplicationContext) {
    val service = context.getBean(RssService::class.java)

    //Test Insert
    service.insertRssUrl("https://rss.blog.naver.com/mltmkr.xml")
    service.insertRssUrl("https://rss.blog.naver.com/ppassong.xml")
    service.insertRssUrl("https://rss.blog.naver.com/dadaacademy.xml")

    //Teet Update
//    service.updateBlogCurrentTime("aaa")
}


fun test_feed(context: ConfigurableApplicationContext) {
    val serviceBlog = context.getBean(BlogService::class.java)
    val serviceRss= context.getBean(RssService::class.java)
    val rss = serviceRss.findByUrl("https://rss.blog.naver.com/dadaacademy.xml").first()

    var blog = Blog()
    blog.author = "aut"
    blog.category = "cat"
    blog.rss = rss

    //Test Insert
    serviceBlog.insertFeed(blog)
}