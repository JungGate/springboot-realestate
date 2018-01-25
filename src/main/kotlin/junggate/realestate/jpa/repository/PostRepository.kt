package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Int> {
}