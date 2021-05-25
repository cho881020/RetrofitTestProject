package com.k.testproject.utils

import com.k.testproject.datas.LoginResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class ServerAPI {






    companion object {

        private val hostURL = "http://3.37.32.230"

        private var retrofit: Retrofit? = null

        fun getInstance() : Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(hostURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }



            return retrofit!!
        }
    }


}