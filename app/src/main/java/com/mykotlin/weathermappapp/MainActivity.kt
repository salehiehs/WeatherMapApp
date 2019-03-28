package com.mykotlin.weathermappapp

import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.mykotlin.weathermappapp.Api.CommonApi
import com.mykotlin.weathermappapp.Api.Helper
import com.mykotlin.weathermappapp.Model.RootObject
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    public inner class GetWeather : AsyncTask<String, Void, String>() {
        internal val pd = ProgressDialog(this@MainActivity)
        override fun onPreExecute() {
            pd.setTitle("Please wait...")
            pd.show()
        }

        override fun doInBackground(vararg params: String?): String {
            var stream: String? = null
            var urlstring = params[0]

            val Http = Helper()
            stream = Http.GetHttpData(urlstring.toString())

            return stream
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result!!.contains("Error: Not found city")) {

                pd.dismiss()
                return
            }

            var rootObject:RootObject
            val gson = Gson()
            rootObject = gson.fromJson<RootObject>(result,RootObject::class.java)
            pd.dismiss()

            //set Data to UI

            txtCity.text = "${rootObject.name},${rootObject.sys!!.country}"
            txtLastUpdate.text = "Last Update: ${CommonApi.dateNow}"
            txtDescription.text = "${rootObject.weather!![0].description}"
            txtTime.text = "${CommonApi.UnixTimeStampToDateTime(rootObject.sys!!.sunrise)}/${CommonApi.UnixTimeStampToDateTime(rootObject.sys!!.sunset)}"
            txtHumidity.text =  "${rootObject.main!!.humidity}"
            txtCelsius.text = "${rootObject.main!!.temp} .C"
            Picasso.with(this@MainActivity).load(CommonApi.getImage(rootObject.weather[0]!!.icon!!))
                    .into(Imageview)






        }




    }

}
