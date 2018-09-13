package junggate.realestate

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.service.RssService
import junggate.realestate.jpa.service.BlogService
import junggate.realestate.jpa.service.PostService
//import junggate.realestate.scheduler.BatchScheduler
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RealestateApplication

fun main(args: Array<String>) {
    SpringApplication.run(RealestateApplication::class.java, *args)
}


fun test_rss(context: ConfigurableApplicationContext) {
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
    val servicePost= context.getBean(PostService::class.java)

    val rss = serviceRss.findByUrl("https://rss.blog.naver.com/dadaacademy.xml").first()

    var blog = Blog(rss = rss)
    blog.author = "aut"
    blog.category = "cat"


    var post = Post(blog = blog)
//    post.author = "한글"
    post.link = "http://naver.com"

    blog.post.add(post)
    serviceBlog.insertBlog(blog)
    servicePost.insertPost(post)

    //Test Insert


}