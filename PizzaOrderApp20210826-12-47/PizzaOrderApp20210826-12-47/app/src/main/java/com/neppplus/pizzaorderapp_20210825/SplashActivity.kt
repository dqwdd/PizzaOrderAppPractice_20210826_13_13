package com.neppplus.pizzaorderapp_20210825

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupEvents()
        setValues()

        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed({
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
            finish()
        }, 3000)
    }

    override fun setupEvents() {
    }
    override fun setValues() {
    }

}