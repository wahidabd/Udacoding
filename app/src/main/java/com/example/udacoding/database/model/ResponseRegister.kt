package com.example.udacoding.database.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

    @field: SerializedName("message")
    val message: String? = null,

    @field: SerializedName("isSuccess")
    val isSuccess: Boolean? = null

)