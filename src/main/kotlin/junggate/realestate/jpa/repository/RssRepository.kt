package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Blog
import junggate.realestate.jpa.model.Rss
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface RssRepository : JpaRepository<Rss, Int> {

    fun findByUrl(url:String): MutableList<Rss>

    @Transactional
    @Modifying
    @Query("UPDATE Rss AS r SET r.updateDate = :updateDate WHERE r.url = :url")
    fun updateDate(@Param("url") url: String,
                             @Param("updateDate") updateDate: String) : Int

}