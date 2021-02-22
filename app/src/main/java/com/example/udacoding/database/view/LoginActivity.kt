package com.example.udacoding.database.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.udacoding.R
import com.example.udacoding.database.helper.SessionManager
import com.example.udacoding.database.model.DataItem
import com.example.udacoding.database.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, LoginPresenter.LoginView {

    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        btn_login.setOnClickListener(this)
        fb_daftar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            fb_daftar -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }

            btn_login -> {
                val email = edt_login_email.editText?.text.toString()
                val password = edt_login_password.editText?.text.toString()
                presenter?.login(email, password)
            }
        }
    }

    override fun onSuccessLogin(msg: Boolean?, user: List<DataItem>?) {
        val session = SessionManager(this)
        session.email = user?.get(0)?.userEmail
        session.nama = user?.get(0)?.userNama
        session.hp = user?.get(0)?.userHp
        session.login = true

        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun onErrorLogin(msg: String) {

    }
}