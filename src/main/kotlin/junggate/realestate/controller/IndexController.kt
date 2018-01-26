package junggate.realestate.controller

import junggate.realestate.component.RssComponent
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