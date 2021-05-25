package com.k.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.k.testproject.datas.LoginResult
import com.k.testproject.utils.ServerAPI
import com.k.testproject.utils.ServerAPIService
import okhttp3.FormBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit : Retrofit
    private lateinit var apiService : ServerAPIService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRetrofit()

        val formBody = FormBody.Builder()
            .add("email", "test@test.com")
            .add("password", "Test!1234")
            .build()

        apiService.postRequestLogin("test@test.com", "Test!123").enqueue(object :Callback<LoginResult> {
            override fun onFailure(call: Call<LoginResult>, t: Throwable) {

                Log.d("응답", "${t}")
                Log.d("콜이어떻게", call.toString())
            }

            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {

                Log.d("응답", "${response}")

                if (response.isSuccessful) {

                    val result = response.body()!!
                    Log.d("결과", result.code.toString())
                    Log.d("결과", result.message.toString())

                    Toast.makeText(this@MainActivity, result.data.user.email, Toast.LENGTH_SHORT).show()
                }
                else {
                    Log.d("에러", response.errorBody().toString())

                }


            }

        })

    }

    private fun initRetrofit(){
        retrofit = ServerAPI.getInstance()
        apiService = retrofit.create(ServerAPIService::class.java)
    }
}