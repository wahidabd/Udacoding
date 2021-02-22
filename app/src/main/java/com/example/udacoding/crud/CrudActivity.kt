package com.example.udacoding.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.udacoding.R
import kotlinx.android.synthetic.main.activity_crud.*
import retrofit2.Call
import retrofit2.Callback

class CrudActivity : AppCompatActivity() {

//    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

//        presenter = Presenter(this)

        btn_submit_input.setOnClickListener{
            val nama = edt_input_name.editText?.text.toString()
            val des = edt_input_deskripsi.editText?.text.toString()
            val prasyarat = edt_input_prasyarat.editText?.text.toString()
            val durasi = edt_input_durasi.editText?.text.toString()

            input(nama, des, prasyarat, durasi)
        }
    }

    private fun input(nama: String, des: String, pra: String, dur: String){
        val input = Network.getApi().input(nama, des, pra, dur)
        input.enqueue(object : Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Toast.makeText(this@CrudActivity, "Berhasil", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Toast.makeText(this@CrudActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}