package com.example.udacoding.database.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object{
        fun getNetwork() : UserService {

            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.1.16/kotlin/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()

            val service = retrofit.create(UserService::class.java)
            return service
        }
    }
}