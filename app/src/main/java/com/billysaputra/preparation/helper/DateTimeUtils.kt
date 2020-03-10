package com.billysaputra.preparation.helper

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Billy Saputra on 2020-03-10.
 */
object DateTimeUtils {
    fun isDateInvalid(date: String, format: String): Boolean {
        return try {
            val df = SimpleDateFormat(format, Locale.getDefault())
            df.isLenient = false
            df.parse(date)
            false
        } catch (e: ParseException) {
            true
        }
    }

    fun getTodayDate() : String{
        val date = Calendar.getInstance().time
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return sdf.format(date)
    }
}