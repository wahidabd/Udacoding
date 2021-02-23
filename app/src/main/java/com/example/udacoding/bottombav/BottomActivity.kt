package com.example.udacoding.bottombav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.udacoding.R
import com.example.udacoding.bottombav.fragment.BussinisFragment
import com.example.udacoding.bottombav.fragment.PopularFragment
import com.example.udacoding.bottombav.fragment.TechFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom.*

class BottomActivity : AppCompatActivity(){

    private lateinit var popularFragment: PopularFragment
    private lateinit var bussinisFragment: BussinisFragment
    private lateinit var techFragment: TechFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        popularFragment = PopularFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, popularFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_pupular -> {
                    popularFragment = PopularFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, popularFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                    true
                }

                R.id.menu_bussinis -> {
                    bussinisFragment = BussinisFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, bussinisFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                    true
                }

                R.id.menu_tech -> {
                    techFragment = TechFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, techFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                    true
                }

                else -> false
            }
        }
    }
}