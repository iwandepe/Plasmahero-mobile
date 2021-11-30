package com.iwan.plasmahero_mobile.ui.event.dummy

import java.util.*

object EventModel {

    val ITEMS: MutableList<EventItem> = ArrayList()
    val ITEM_MAP: MutableMap<String, EventItem> = HashMap()

    private val COUNT = 25

    init {
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: EventItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): EventItem {
        return EventItem(position.toString(), "Event Number #$position", Date().toString(), "This is Description Section", "https://picsum.photos/200/"+(300+position))
    }

    data class EventItem(val id: String, val title: String, val date: String, val desc: String, val imgUrl: String) {
        override fun toString(): String = title
    }
}