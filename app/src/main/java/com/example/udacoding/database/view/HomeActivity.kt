package com.example.udacoding.database.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.udacoding.R
import com.example.udacoding.database.helper.SessionManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private var session: SessionManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        session = SessionManager(this)

        tName.text = session?.nama
        tEmail.text = session?.email
        thp.text = session?.hp

        fb_out.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            fb_out -> {
                session?.logout()
                val intent = Intent(this, LoginActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        }
    }
}