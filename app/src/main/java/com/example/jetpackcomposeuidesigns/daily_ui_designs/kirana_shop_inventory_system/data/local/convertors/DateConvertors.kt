package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.convertors

import androidx.room.TypeConverter
import java.util.Date

class DateConvertors {
    @TypeConverter
    fun toDate(value : Long?) : Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(value : Date?) : Long? {
        return value?.time?.toLong()
    }
}