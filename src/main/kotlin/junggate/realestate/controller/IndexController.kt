package junggate.realestate.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController{
    @GetMapping("index")
    fun index() : String{
        return "index"
    }

}