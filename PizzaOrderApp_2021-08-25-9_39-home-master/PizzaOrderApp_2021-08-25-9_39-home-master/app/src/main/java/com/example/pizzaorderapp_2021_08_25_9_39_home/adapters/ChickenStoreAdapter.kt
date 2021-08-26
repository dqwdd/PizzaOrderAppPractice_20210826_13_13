package com.example.pizzaorderapp_2021_08_25_9_39_home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_2021_08_25_9_39_home.R
import com.example.pizzaorderapp_2021_08_25_9_39_home.datas.StoreData

class ChickenStoreAdapter(
    val mContext : Context,
    resId : Int,
    val mList : List<StoreData>) : ArrayAdapter<StoreData>(mContext, resId, mList) {

        val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var temRow = convertView
        if (temRow==null) {
            temRow = mInflater.inflate(R.layout.store_list_item_chi, null)
        }

        var row = temRow!!

        val data = mList[position]
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)

        nameTxt.text = data.name

        Glide.with(mContext).load(data.LogoURL).into(logoImg)

        
        return row
    }

}