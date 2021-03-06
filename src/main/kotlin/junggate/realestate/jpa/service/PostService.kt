package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.model.Rss
import junggate.realestate.jpa.repository.BlogRepository
import junggate.realestate.jpa.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PostService@Autowired constructor(private val postRepository: PostRepository){
    fun findAll(pageable: Pageable): Page<Post>? {
        return postRepository.findAll(pageable = pageable)
    }

    fun insertPost(post: Post){
        postRepository.save(post)
    }

    fun find(link:String): Post?{
        val result = postRepository.findAll().filter { it.link == link }
        return if (result.count() > 0) result.first() else null
    }

}