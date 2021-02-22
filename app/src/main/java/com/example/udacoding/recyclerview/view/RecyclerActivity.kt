package com.example.udacoding.recyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udacoding.R
import com.example.udacoding.recyclerview.model.Hero
import com.example.udacoding.recyclerview.model.HeroData
import com.example.udacoding.recyclerview.model.ListHeroAdapter
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    private var list: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        rv_view.setHasFixedSize(true)
        list.addAll(HeroData.listData)
        showList()
    }

    private fun showSelectedHero(hero: Hero){
        Toast.makeText(this, hero.name, Toast.LENGTH_LONG).show()
    }

    private fun showList(){
        rv_view.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rv_view.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
                val intent = Intent(this@RecyclerActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, data)
                startActivity(intent)
            }
        })
    }
}