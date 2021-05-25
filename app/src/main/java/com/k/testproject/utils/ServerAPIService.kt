package com.k.testproject.utils

import com.k.testproject.datas.LoginResult
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ServerAPIService {

    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(@Field("email") email:String, @Field("password") pw:String) : Call<LoginResult>
}