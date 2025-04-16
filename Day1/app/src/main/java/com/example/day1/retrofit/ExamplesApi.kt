package com.example.day1.retrofit

import com.example.day1.retrofit.models.Post
import com.example.day1.retrofit.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ExamplesApi {


    @GET("users")
    fun getUsers():Call<List<User>>


    @POST("posts")
    fun createPost(@Body post: Post):Call<Post>

    @DELETE("posts/{id}")
    fun deletePostById(@Path("id") id: Int): Call<Unit>


    @GET("posts")
    fun queryPost(@Query("id") id: Int, @Query("user") userId:Int): Call<Unit>
}