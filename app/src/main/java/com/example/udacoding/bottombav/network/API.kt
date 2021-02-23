package com.example.udacoding.bottombav.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("everything?q=olahraga&from=2021-01-23&sortBy=publishedAt&apiKey=5b451eae6c2e4deebf2840f83664a528")
    fun getPopuler(): Observable<ResponsePopuler>
}