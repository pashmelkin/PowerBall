package com.example.powerballpredict

import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

 class ApiService : AsyncTask<URL?, Int?, String>() {
     private var _result : String = ""
     override fun doInBackground(vararg p0: URL?): String {
         var client = OkHttpClient()

         val request = Request.Builder()
             .url(p0[0]!!)
             .build()

         client.newCall(request).execute().use { response -> _result =  response.body!!.string() }
         return _result
         }

     override fun onPostExecute(result: String?) {
         println(message = "Result in onPostExecute is ${_result}")
     }


 }
