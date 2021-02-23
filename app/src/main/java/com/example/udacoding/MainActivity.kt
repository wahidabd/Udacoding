package com.example.udacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.udacoding.bottombav.BottomActivity
import com.example.udacoding.crud.CrudActivity
import com.example.udacoding.database.view.LoginActivity
import com.example.udacoding.database.view.splash.SplashActivity
import com.example.udacoding.kalkulator.view.KalkulatorActivity
import com.example.udacoding.recyclerview.view.RecyclerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_kalkulator.setOnClickListener(this)
        btn_recyclerview.setOnClickListener(this)
        btn_database.setOnClickListener(this)
        btn_crud.setOnClickListener(this)
        btn_news_api.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btn_kalkulator -> {
                val intent = Intent(this, KalkulatorActivity::class.java)
                startActivity(intent)
            }

            btn_recyclerview -> {
                val intent = Intent(this, RecyclerActivity::class.java)
                startActivity(intent)
            }

            btn_database -> {
                val intent = Intent(this, SplashActivity::class.java)
                startActivity(intent)
            }

            btn_crud -> {
                startActivity(Intent(this, CrudActivity::class.java))
            }

            btn_news_api -> {
                startActivity(Intent(this, BottomActivity::class.java))
            }
        }
    }
}