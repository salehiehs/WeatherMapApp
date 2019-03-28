package com.mykotlin.weathermappapp.Api

import java.text.SimpleDateFormat
import java.util.*

object CommonApi
{
    val API_KEY = "c392bbede18d080c6e2ff93e1851bd04"
    val API_LINK = "http://api.openweathermap.org/data/2.5/weather"


    fun apiRequest(lat:String,lng:String):String{
        var sb = StringBuilder(API_LINK)
        sb.append("?lat=${lat}&lon=${lng}&APPID=${API_KEY}&units=metric")
        return  sb.toString()

    }

    fun UnixTimeStampToDateTime(unitTimeStamp:Int):String
    {
        val DateFormat = SimpleDateFormat("HH:mm")
        val date = Date()
        date.time = unitTimeStamp.toLong()*1000
        return DateFormat.format(date)
    }

    fun getImage(icon:String):String
    {
        return "http//openweathermap.org/img/w/${icon}.png"
    }

    val dateNow:String
        get()
        {
            val dateFormat = SimpleDateFormat("HH MM yyyy HH:mm")

            val date = Date()
            return dateFormat.format(date)

        }

        val Stream:String=""


}