package com.mykotlin.weathermappapp.Api

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Helper {

    fun HttpDataHandler(){}
    fun  GetHttpData(urlstring:String):String
    {
        var stream = CommonApi.Stream
        try {
            val url = URL(urlstring)
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            if(urlConnection.responseCode == HttpURLConnection.HTTP_OK )
            {
                val inputStream: InputStream = BufferedInputStream(urlConnection.inputStream) as InputStream
                val r = BufferedReader(InputStreamReader(inputStream))
                val sb = StringBuilder()
                var line:String
                line = r.readLine()
                sb.append(line)
                stream = sb.toString()
            }
        }
        catch (E:Exception){}

        return stream
    }
}