package com.block.note.presentation.utils

import android.annotation.SuppressLint
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    @SuppressLint("SimpleDateFormat")
    fun convertToStringDateHourMinuteMiles(millis: Long): String {
        val date = Date()
        date.time = millis
        val formatter = SimpleDateFormat("dd.mm.yyyy, hh:mm:ss", DateFormatSymbols(Locale.getDefault()))
        val textDate = formatter.format(date)
        val res = textDate
            .substring(0, 1)
            .toUpperCase(Locale.getDefault()) + textDate.substring(1)
            .toLowerCase(Locale.getDefault())
        return res
    }
}