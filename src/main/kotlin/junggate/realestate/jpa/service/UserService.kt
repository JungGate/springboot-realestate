package junggate.realestate.jpa.service

import junggate.realestate.jpa.model.Role
import junggate.realestate.jpa.model.User
import junggate.realestate.jpa.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import junggate.realestate.jpa.repository.RoleRepository

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository,
                                         private val roleRepository: RoleRepository,
                                         private val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    fun saveUser(user: User) {
        user.password = bCryptPasswordEncoder.encode(user.password)
        user.active = 1

        val role = roleRepository.findByRole("ADMIN")
        user.roles = setOf(role)

        userRepository.save(user)
    }
}