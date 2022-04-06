package com.example.data.remote.model

import com.google.gson.annotations.SerializedName

data class DataUserInfo(
    @SerializedName("login")
    val userId: String,
    val followers: Int,
    val following: Int,
)
