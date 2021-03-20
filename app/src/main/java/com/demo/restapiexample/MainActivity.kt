package com.demo.restapiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rf=Retrofit.Builder()
            .baseUrl(RetroInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        //define api

//API  IS INITIALISED THIS WAY
        var API:RetroInterface=rf.create(RetroInterface::class.java)
        var call:Call<List<PostModel?>?>?=API.posts
        call?.enqueue(object:Callback<List<PostModel?>?>{
            override fun onResponse(
                call: Call<List<PostModel?>?>,
                response: Response<List<PostModel?>?>
            ) {

                var postlist:List<PostModel>?= response.body() as List<PostModel>
                val post = arrayOfNulls<String>(postlist!!.size)
                for( i:Int in postlist!!.indices)
                    post[i]=postlist!![i]!!.title

                var adapter=ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)
                list_view1.adapter=adapter



            }

            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {

            }

        })
    }


}