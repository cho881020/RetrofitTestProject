package com.k.testproject.utils

import com.k.testproject.datas.DefaultResponse
import retrofit2.Call
import retrofit2.http.*

interface ServerAPIService {

    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(@Field("email") email:String, @Field("password") pw:String) : Call<DefaultResponse>

    @GET("/user")
    fun getRequestUser(@Header("X-Http-Token") token:String) : Call<DefaultResponse>
}