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

    override fun write(items:MutableList<out SyndFeed>?){
        if (items == null)
            return

        items.forEach { syndFeed: SyndFeed ->
            println("[writer]${syndFeed.title}")
            println("[writer]${syndFeed.uri}")

            val rss = serviceRss.findByUrl(syndFeed.uri).first()

            var blog = Blog(rss = rss)
//            blog.author = syndFeed.author
//            blog.category = syndFeed.categories.first()
            blog.title = syndFeed.title
            blog.description = syndFeed.description
            serviceBlog.insertBlog(blog)

            syndFeed.entries.forEach { syndEntry: SyndEntry? ->
                if (syndEntry != null) {
                    var post = Post(blog = blog)
                    post.author = syndEntry.author
                    post.link = syndEntry.link
//                    post.description = syndEntry.description
                    post.title = syndEntry.title

//                    blog.post.add(post)

                    servicePost.insertPost(post)
                }
            }
        }
    }
}