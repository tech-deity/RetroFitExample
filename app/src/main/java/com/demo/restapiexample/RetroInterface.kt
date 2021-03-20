package com.demo.restapiexample

import retrofit2.Call
import retrofit2.http.GET

interface RetroInterface {

    @get:GET("posts")
    val posts: Call<List<PostModel?>?>?  // https://jsonplaceholder.typicode.com/posts was complete url and Call is the CAll back  we use GET("posts") to get data from the complete url



    companion object{
        const val BASE_URL="https://jsonplaceholder.typicode.com" // this is the base url

    }
}