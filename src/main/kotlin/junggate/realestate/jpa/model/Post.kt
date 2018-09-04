package junggate.realestate.jpa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "post")
data class Post(

        @Id
        @GeneratedValue
        var id:Int? = 0,

//        @Column(nullable = false)
//        var author: String = "",

        @Column(nullable = false)
        var category: String = "",

        @Column(nullable = false)
        var title: String = "",

        @Column(nullable = false)
        var link: String = "",

//        @Column(nullable = false)
//        var guid: String = "",

        @Column(nullable = false, length = 1024)
        var description: String = "",

        @Column
        var pubDate: Date? = null,

//        @Column(nullable = true) // ROME에 값이 없어 ㅠㅠ
//        var tag: String? = null,

        @ManyToOne(cascade = arrayOf(CascadeType.ALL))
        var blog: Blog? = null
)
