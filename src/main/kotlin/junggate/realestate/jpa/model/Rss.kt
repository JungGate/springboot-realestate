package junggate.realestate.jpa.model

import junggate.realestate.component.DateUtil
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
        var initUpdateDate: String = DateUtil.getCurrentDate(),

        @Column(nullable = false)
        var lastUpdateDate: String = ""
)