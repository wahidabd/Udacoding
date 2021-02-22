package com.example.udacoding.kalkulator.presenter

import com.example.udacoding.kalkulator.model.Kalkulator

class KalkulatorPresenter(val kalView: KalkulatorView) {

    fun hasilKali(value1: String, value2: String){
        val value1 = value1.toInt()
        val value2 = value2.toInt()

        val total: Int = value1.times(value2)

        val kalkulator = Kalkulator()
        kalkulator.total = total

        kalView.bindView(kalkulator)
    }

    fun hasilBagi(value1: String, value2: String){
        val value1 = value1.toInt()
        val value2 = value2.toInt()

        val total: Int = value1.div(value2)

        val kalkulator = Kalkulator()
        kalkulator.total = total
        kalView.bindView(kalkulator)
    }

    fun hasilKurang(value1: String, value2: String){
        val value1 = value1.toInt()
        val value2 = value2.toInt()

        val total: Int = value1 - value2

        val kalkulator = Kalkulator()
        kalkulator.total = total
        kalView.bindView(kalkulator)
    }

    fun hasilTambah(value1: String, value2: String){
        val value1 = value1.toInt()
        val value2 = value2.toInt()

        val total: Int = value1 + value2

        val kalkulator = Kalkulator()
        kalkulator.total = total
        kalView.bindView(kalkulator)
    }

}