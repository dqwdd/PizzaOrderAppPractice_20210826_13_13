package com.neppplus.pizzaorderapppractice_20210826_13_13

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neppplus.pizzaorderapppractice_20210826_13_13.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_chicken_store_detail.*
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import kotlinx.android.synthetic.main.activity_view_store_detail.dialBtn
import kotlinx.android.synthetic.main.activity_view_store_detail.homepageBtn
import kotlinx.android.synthetic.main.activity_view_store_detail.logoImg
import kotlinx.android.synthetic.main.activity_view_store_detail.nameTxt
import kotlinx.android.synthetic.main.activity_view_store_detail.phoneNumTxt

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
            val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
            val myIntent = Intent( Intent.ACTION_DIAL, myUri )
            startActivity(myIntent)
        }
        homepageBtn.setOnClickListener {
            val myUri = Uri.parse("${mStoreData.homepageURL}")
            val myIntent = Intent( Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        mStoreData = intent.getSerializableExtra("store") as StoreData

        nameTxt.text = mStoreData.name
        phoneNumTxt.text = mStoreData.phoneNum

        Glide.with(mContext).load(mStoreData.logoURL).into(logoImg)
    }
}