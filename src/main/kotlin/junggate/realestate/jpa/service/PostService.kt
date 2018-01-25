package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import junggate.realestate.jpa.repository.BlogRepository
import junggate.realestate.jpa.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService@Autowired constructor(private val postRepository: PostRepository){
    fun insertPost(post: Post){
        postRepository.save(post)
    }

}