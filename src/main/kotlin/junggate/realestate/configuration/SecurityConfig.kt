package junggate.realestate.configuration

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


//@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity?) {
        super.configure(web)
//        if (web != null) {
//            web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**")
//        }
    }

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
//        if (http != null) {
//            http.authorizeRequests()
//                    .antMatchers("/admin/**")
//                    .hasRole("ADMIN")
//                    .antMatchers("/**").permitAll()
//        }
    }
}