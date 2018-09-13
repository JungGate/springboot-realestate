package junggate.realestate.jpa.model

import junggate.realestate.component.DateUtil
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "rss")
data class Rss(
        @Id
        @GeneratedValue
        var id:Int? = 0,

        @Column(nullable = false)
        var url: String = "",

        @Column(nullable = false)
        var subscribeDate: Date = Date(),

        @Column(nullable = false)
        var updateDate: Date = Date()
)