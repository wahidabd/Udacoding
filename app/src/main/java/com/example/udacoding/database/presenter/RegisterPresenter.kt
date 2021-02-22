package com.example.udacoding.database.presenter

import com.example.udacoding.database.model.ResponseRegister
import com.example.udacoding.database.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {
    fun register(nama: String, hp: String, email: String, password: String, passwordConfirm: String){

        ConfigNetwork.getNetwork().register(nama, hp, email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                registerView.onSuccessRegister(it)
            }, {
                registerView.onErrorRegister(it.localizedMessage)
            })


//        if(nama.isNotEmpty() && hp.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
//
//            if (password != passwordConfirm){
//                registerView.noMatch()
//            }else if(password.length < 6){
//                registerView.onErrorRegister("Password harus labih dari 6")
//            }else {
//
//                ConfigNetwork.getNetwork().register(nama, hp, email, password)
//                    .enqueue(object : Callback<ResponseRegister> {
//
//                        override fun onResponse(
//                            call: Call<ResponseRegister>,
//                            response: Response<ResponseRegister>
//                        ) {
//                            if (response.isSuccessful) {
//                                val responseServer = response.body()
//                                val message = response.body()?.message
//                                val status = response.body()?.isSuccess
//
//                                if (status ?: true) {
//                                    responseServer?.let { registerView.onSuccessRegister(it) }
//                                } else {
//                                    registerView.onErrorRegister(message ?: "")
//                                }
//                            }
//                        }
//
//                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
//                            registerView.onErrorRegister(t.localizedMessage)
//                        }
//                    })
//            }
//        }else{
//            registerView.empty()
//        }
    }


    interface RegisterView{
        fun onSuccessRegister(response: ResponseRegister)
        fun onErrorRegister(msg: String)
        fun empty()
        fun noMatch()
    }
}

