package com.example.pizzaorderapp_2021_08_25_9_39_home

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this
    abstract fun setupEvents()
    abstract fun setValues()

}