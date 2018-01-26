package junggate.realestate.component

import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*

@Component
class DateUtil{
    companion object {
        fun getCurrentDate() : String{
            var dateformat = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z")
            return dateformat.format(Date())
        }
    }
}