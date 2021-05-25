package com.k.testproject.utils

import com.k.testproject.datas.LoginResult
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Part

interface ServerAPIService {
    @POST("/user")
    fun postRequestLogin(@Body body: RequestBody) : Call<LoginResult>
}