package junggate.realestate.jpa.model

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*


@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uesr_id")
    var id: Int = 0,

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Transient
    var password:String? = "",

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    var name:String? = "",

    @Column(name = "active")
    var active: Int = 0,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
    var roles: Set<Role>? = mutableSetOf()
)