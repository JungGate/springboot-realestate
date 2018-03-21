package junggate.realestate.jpa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "blog")
data class Blog(

        @Id
        @GeneratedValue
        var id: Int = 0,

        @Column(nullable = true)
        var author: String? = null,

        @Column(nullable = false)
        var category: String = "",

        @Column(nullable = false)
        var title: String = "",

        @Column(nullable = false)
        var link: String = "",

//        @Column(nullable = false)
//        var guid: String = "",

        @Column(nullable = false)
        var description: String = "",

        @Column(nullable = true)
        var pubDate: Date? = null,

        @Column(nullable = true)
        var tag: String? = null,

        @OneToOne
        @JsonBackReference
        var rss: Rss? = null,

        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JsonBackReference
        var post: MutableList<Post> = mutableListOf()
)