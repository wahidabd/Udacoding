package com.example.udacoding.database.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.udacoding.R
import com.example.udacoding.database.model.ResponseRegister
import com.example.udacoding.database.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterPresenter.RegisterView, View.OnClickListener {

    private var presenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)
        btn_daftar.setOnClickListener(this)
    }

    override fun onSuccessRegister(response: ResponseRegister) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onErrorRegister(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("harus diisi")
    }

    override fun noMatch() {
        showToast("Password tidak sama")
    }

    override fun onClick(v: View?) {
        when(v){
            btn_daftar -> {
                val nama = edt_register_nama.editText?.text.toString()
                val email = edt_register_email.editText?.text.toString()
                val hp = edt_register_nohp.editText?.text.toString()
                val password = edt_login_password.editText?.text.toString()
                val passwordConfirm = edt_login_password_confirm.editText?.text.toString()
                presenter?.register(nama, hp, email, password, passwordConfirm)
            }
        }
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}