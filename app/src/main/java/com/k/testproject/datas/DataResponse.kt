package com.k.testproject.datas

data class DataResponse(
    var user : UserModel,
    var token : String,
    var users : List<UserModel>

)