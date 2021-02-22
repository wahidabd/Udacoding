package com.example.udacoding.crud

import com.google.gson.annotations.SerializedName

data class Response(
    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("isSuccess")
    val isSuccess: Boolean? = null
)