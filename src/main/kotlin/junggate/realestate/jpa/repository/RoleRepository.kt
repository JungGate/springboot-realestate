package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Int> {
    fun findByRole(role: String): Role
}