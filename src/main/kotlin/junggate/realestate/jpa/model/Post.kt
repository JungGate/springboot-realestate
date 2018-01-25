package junggate.realestate.jpa.model

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "post")
data class Post(

        @Id
        @GeneratedValue
        var id:Int? = 0,

        @Column(nullable = false)
        var author: String = ""
//
//        @Column(nullable = false)
//        var category: String = "",
//
//        @Column(nullable = false)
//        var title: String = "",
//
//        @Column(nullable = false)
//        var link: String = "",
//
//        @Column(nullable = false)
//        var guid: String = "",
//
//        @Column(nullable = false)
//        var description: String = "",
//
//        @Column
//        var pubDate: String = "", // SimpleDateFormat //"EEE, d MMM yyyy HH:mm:ss Z"    Wed, 4 Jul 2001 12:08:56 -0700
//
//        @Column(nullable = false)
//        var tag: String = "",
//
//        @ManyToOne
//        @JoinColumn(name = "blog")
//        var blog: Blog? = null


)