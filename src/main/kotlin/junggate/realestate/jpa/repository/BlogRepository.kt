package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BlogRepository: JpaRepository<Blog, Int> {

    fun findByUrl(url:String): MutableList<Blog>

    @Transactional
    @Modifying
    @Query("UPDATE Blog AS b SET b.lastUpdateDate = :lastUpdateDate WHERE b.url = :url")
    fun updateLastUpdateDate(@Param("url") url: String,
                             @Param("lastUpdateDate") updateDate: String) : Int

}