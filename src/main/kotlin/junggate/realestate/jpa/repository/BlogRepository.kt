package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BlogRepository : JpaRepository<Blog, Int> {
}