package com.manish.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface github{
@GET("users")
suspend fun getAllusers():Response<List<User>>
}