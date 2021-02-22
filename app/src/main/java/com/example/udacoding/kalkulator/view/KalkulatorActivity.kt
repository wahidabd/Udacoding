package com.example.udacoding.kalkulator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udacoding.R
import com.example.udacoding.kalkulator.model.Kalkulator
import com.example.udacoding.kalkulator.presenter.KalkulatorPresenter
import com.example.udacoding.kalkulator.presenter.KalkulatorView
import kotlinx.android.synthetic.main.activity_kalkulator.*

class KalkulatorActivity : AppCompatActivity(), KalkulatorView {

    private var presenter: KalkulatorPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        presenter = KalkulatorPresenter(this)

        btn_kali.setOnClickListener {
            val value1 = edt_input1.text.toString()
            val value2 = edt_input2.text.toString()
            presenter?.hasilKali(value1, value2)
        }


        btn_bagi.setOnClickListener {
            val value1 = edt_input1.text.toString()
            val value2 = edt_input2.text.toString()
            presenter?.hasilBagi(value1, value2)
        }


        btn_kurang.setOnClickListener {
            val value1 = edt_input1.text.toString()
            val value2 = edt_input2.text.toString()
            presenter?.hasilKurang(value1, value2)
        }
        btn_tambah.setOnClickListener {
            val value1 = edt_input1.text.toString()
            val value2 = edt_input2.text.toString()
            presenter?.hasilTambah(value1, value2)
        }
    }

    override fun bindView(kal: Kalkulator) {
        val hasil = kal.total
        tv_hasil.text = hasil.toString()
    }
}