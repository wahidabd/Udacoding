package com.example.udacoding.crud

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{

        private const val BASE_URL = "http://192.168.1.16/kotlin/"

        fun getApi(): Api{
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}