package com.mykotlin.weathermappapp.Model

import java.lang.reflect.Constructor

data class RootObject(


        val base:String,
        val clouds: Clouds,
        val cod: Int,
        val coord: Coord,
        val dt: Int,
        val id: Int,
        val main: Main,
        val name: String,
        val sys: Sys,
        val weather: List<Weather>,
        val wind: Wind


)
