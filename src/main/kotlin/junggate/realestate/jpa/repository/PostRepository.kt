package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Int> {
    override fun findAll(pageable: Pageable): Page<Post>?
    override fun findAll(sort: Sort): List<Post>
}