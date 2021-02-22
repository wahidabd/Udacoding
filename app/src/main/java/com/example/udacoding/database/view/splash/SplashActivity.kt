package com.example.udacoding.database.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.udacoding.R
import com.example.udacoding.database.helper.SessionManager
import com.example.udacoding.database.view.HomeActivity
import com.example.udacoding.database.view.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val session = SessionManager(this)
        Handler().postDelayed(Runnable {
            if(session.login ?: true){
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }

            finish()

        }, 2000)
    }
}