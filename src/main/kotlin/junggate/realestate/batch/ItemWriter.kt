package junggate.realestate.batch

import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.service.BlogService
import junggate.realestate.jpa.service.PostService
import junggate.realestate.jpa.service.RssService
import org.springframework.stereotype.Component
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

@Component
class ItemWriter:ItemWriter<SyndFeed>{
    @Autowired
    private lateinit var serviceBlog: BlogService

    @Autowired
    private lateinit var servicePost: PostService

    @Autowired
    private lateinit var serviceRss: RssService

    constructor(servicePost: PostService) {
        this.servicePost = servicePost
    }

    override fun write(items:MutableList<out SyndFeed>?){
        if (items == null)
            return

        items.forEach { syndFeed: SyndFeed ->
            val rss = serviceRss.findByUrl(syndFeed.uri).first()

            var blog = Blog(rss = rss)
            blog.author = syndFeed.author
            blog.category = syndFeed.categories.map { it.name }.toString()
            blog.title = syndFeed.title
            blog.link = syndFeed.link
            blog.pubDate = syndFeed.publishedDate
            blog.description = syndFeed.description
            serviceBlog.insertBlog(blog)

            syndFeed.entries.forEach { syndEntry ->
                var post = Post(blog = blog)
                post.category = syndEntry.categories.map{
                    it.name
                }.reduce { result, s ->
                    result + ", " + s
                }
                post.title = syndEntry.title
                post.link = syndEntry.link
                val syndContent = syndEntry.description
                post.description = syndContent.value
                post.pubDate = syndEntry.publishedDate
                blog.post.add(post)

                println("[writer]${post.title}")
                println("[writer]\n")

                servicePost.insertPost(post)
            }
        }
    }
}