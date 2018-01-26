package junggate.realestate.batch

import org.springframework.stereotype.Component
import org.springframework.batch.item.ItemWriter

@Component
open class ItemWriter:ItemWriter<String>{
    override fun write(items:MutableList<out String>?){
        println("[writer]${items}")
    }
}