package com.example.data.remote.api

import com.example.data.remote.model.DataUserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("/users/{owner}")
    suspend fun getUserInfo(@Path("owner") owner: String): Response<DataUserInfo>
}