package com.example.udacoding.recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.udacoding.R
import com.example.udacoding.recyclerview.model.Hero
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getParcelableExtra<Hero>(EXTRA_DATA)

        tv_detail_name.text = user?.name
        tv_detail_des.text= user?.detail

        Glide.with(this)
                .load(user?.photo)
                .into(img_detail_image)
    }
}