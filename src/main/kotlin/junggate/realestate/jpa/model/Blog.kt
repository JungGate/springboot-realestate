package junggate.realestate.jpa.model

import junggate.realestate.util.DateUtil
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.cdi.Eager
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "blog")
data class Blog(
        @Id
        @GeneratedValue
        var id:Int? = 0,

        @Column(nullable = false)
        var url: String = "",

        @Column(nullable = false)
        var initUpdateDate: String = DateUtil.getCurrentDate(),

        @Column(nullable = false)
        var lastUpdateDate: String = "",

        @OneToMany(mappedBy = "blog")
        var feedList: List<Feed>? = null
)