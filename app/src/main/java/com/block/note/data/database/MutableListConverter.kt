package com.block.note.data.database

import android.bluetooth.BluetoothClass
import androidx.room.TypeConverter
import com.beust.klaxon.Klaxon
import com.block.note.data.entity.Note
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MutableListConverter {

    @TypeConverter
    fun fromDeviceList(list: MutableList<Note>?): String {
        val res = Klaxon().toJsonString(list)
        return res
    }

    @TypeConverter
    fun toDeviceList(data: String): MutableList<Note>? {
        val gson = Gson()
        val type = object : TypeToken<MutableList<BluetoothClass.Device>?>() {}.type
        return gson.fromJson(data, type)
    }
}