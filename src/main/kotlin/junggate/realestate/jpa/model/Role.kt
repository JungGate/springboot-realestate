package junggate.realestate.jpa.model;

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "role_id")
        private var id: Int = 0,

        @Column(name = "role")
        private var role: String = ""
)
