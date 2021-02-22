package com.example.udacoding.database.network

import com.example.udacoding.database.model.ResponseLogin
import com.example.udacoding.database.model.ResponseRegister
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("nama") nama: String,
        @Field("nohp") nohp: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Single<ResponseRegister>

    @FormUrlEncoded
    @POST("login.php")
    fun login(
            @Field("email") email: String,
            @Field("password") password: String
    ): Observable<ResponseLogin>
}