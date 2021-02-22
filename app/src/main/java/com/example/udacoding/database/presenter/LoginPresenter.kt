package com.example.udacoding.database.presenter

import com.example.udacoding.database.model.DataItem
import com.example.udacoding.database.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginPresenter(val loginView: LoginView) {

    fun login(email: String, password: String){

        ConfigNetwork.getNetwork().login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       loginView.onSuccessLogin(it.isSuccess, it.data as List<DataItem>?)
            }, {
                it.localizedMessage
            })

//        ConfigNetwork.getNetwork().login(email, password)
//                .enqueue(object : Callback<ResponseLogin>{
//                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
//                        if(response.isSuccessful){
//                            val status = response.body()?.isSuccess
//                            val message = response.body()?.message
//
//                            if (status ?: true){
//                                message?.let { loginView.onSuccessLogin(it, response.body()!!.data as List<DataItem>?) }
//                            }else{
//                                loginView.onErrorLogin(message ?: "")
//                            }
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                        loginView.onErrorLogin(t.localizedMessage)
//                    }
//
//                })
    }

    interface LoginView{
        fun onSuccessLogin(msg: Boolean?, user: List<DataItem>?)
        fun onErrorLogin(msg: String)
    }
}