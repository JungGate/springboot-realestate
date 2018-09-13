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