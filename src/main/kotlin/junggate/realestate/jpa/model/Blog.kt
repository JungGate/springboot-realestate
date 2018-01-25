package junggate.realestate.jpa.model

import javax.persistence.*


@Entity
@Table(name = "blog")
data class Blog(

        @Id
        @GeneratedValue
        var id: Int = 0,

        @Column(nullable = false)
        var author: String = "",

        @Column(nullable = false)
        var category: String = "",

        @Column(nullable = false)
        var title: String = "",

        @Column(nullable = false)
        var link: String = "",

        @Column(nullable = false)
        var guid: String = "",

        @Column(nullable = false)
        var description: String = "",

        @Column
        var pubDate: String = "", // SimpleDateFormat //"EEE, d MMM yyyy HH:mm:ss Z"    Wed, 4 Jul 2001 12:08:56 -0700

        @Column(nullable = false)
        var tag: String = "",

        @OneToOne
        var rss: Rss? = null,

        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        var post: MutableList<Post> = mutableListOf()


)