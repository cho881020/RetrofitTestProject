package com.k.testproject.datas

import com.google.gson.annotations.SerializedName

data class UserModel(
    var email:String,
    @SerializedName("nick_name")
    var nickName: String
)