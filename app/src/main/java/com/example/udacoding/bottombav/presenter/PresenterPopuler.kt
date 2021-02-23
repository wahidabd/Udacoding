package com.example.udacoding.bottombav.presenter

import com.example.udacoding.bottombav.network.ArticlesItem
import com.example.udacoding.bottombav.network.RetrofitClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PresenterPopuler(val populerView : PopulerView) {

    fun getPopuler(){
        RetrofitClient.instance.getPopuler()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       populerView.onSuccess(it.status, it.articles)
            }, {
                populerView.onError(it.localizedMessage)
            })
    }

    interface PopulerView{
        fun onSuccess(msg: String?, article: List<ArticlesItem?>?)
        fun onError(msg: String)
    }
}