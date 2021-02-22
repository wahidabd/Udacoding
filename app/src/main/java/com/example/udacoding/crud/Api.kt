package com.example.udacoding.crud

import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("insert.php")
    fun input(
        @Field("nama")nama: String,
        @Field("deskripsi")deskripsi: String,
        @Field("sarat")prasyarat: String,
        @Field("durasi")durasi: String
    ): Call<Response>

}