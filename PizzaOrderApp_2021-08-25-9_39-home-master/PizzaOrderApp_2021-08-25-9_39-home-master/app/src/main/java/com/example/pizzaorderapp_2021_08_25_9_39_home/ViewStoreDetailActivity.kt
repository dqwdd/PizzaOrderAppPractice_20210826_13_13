package com.example.pizzaorderapp_2021_08_25_9_39_home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_2021_08_25_9_39_home.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData: StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        dialBtn.setOnClickListener {

            val myUri = Uri.parse("tel:${mStoreData.PhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

            mStoreData = intent.getSerializableExtra("store") as StoreData

            nameTxt.text = mStoreData.name
            phoneNumTxt.text = mStoreData.PhoneNum

            Glide.with(mContext).load(mStoreData.LogoURL).into(logoImg_in_DetailView)

    }
 }
