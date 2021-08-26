package com.example.pizzaorderapp_2021_08_25_9_39_home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_2021_08_25_9_39_home.adapters.MainViewPagerAdapter
import com.example.pizzaorderapp_2021_08_25_9_39_home.datas.StoreData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import kotlinx.android.synthetic.main.store_list_item.*
import kotlinx.android.synthetic.main.store_list_item.nameTxt

class MainActivity : BaseActivity() {

    lateinit var mainViewPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {
    }

    override fun setValues() {

        mainViewPagerAdapter = MainViewPagerAdapter( supportFragmentManager )
        mainViewPager.adapter = mainViewPagerAdapter
        mainTabLayout.setupWithViewPager( mainViewPager )
}
}