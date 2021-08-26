package com.neppplus.pizzaorderapppractice_20210826_13_13.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neppplus.pizzaorderapppractice_20210826_13_13.R
import com.neppplus.pizzaorderapppractice_20210826_13_13.ViewStoreDetailActivity
import com.neppplus.pizzaorderapppractice_20210826_13_13.adapters.PizzaStoreAdapter
import com.neppplus.pizzaorderapppractice_20210826_13_13.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*


class PizzaStoreListFragment : Fragment() {

    val mPizzaStores = ArrayList<StoreData>()
    lateinit var mPizzaStoreAdapter : PizzaStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate( R.layout.fragment_pizza_store_list, container, false )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mPizzaStores.clear()

        mPizzaStores.add(  StoreData("피자헛", "1588-5588", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg", "https://www.pizzahut.co.kr/cs/event/204?utm_campaign=BrandSearch_PC&utm_medium=brand&utm_source=naver&utm_content=hyukgoods_main")  )
        mPizzaStores.add(  StoreData("파파존스", "1577-8080", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800", "https://pji.co.kr/?NaPm=ct%3Dkssjknjt%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3Dce0ecf12c6db089fa21c1720bce09f68a5d0517c")  )
        mPizzaStores.add(  StoreData("미스터피자", "1577-0077", "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200", "https://mrpizza.co.kr/event/new_menu?utm_source=naver&utm_medium=cpc&utm_campaign=bsa&utm_content=pc_main_image&utm_term=mexican2&n_media=27758&n_query=%EB%AF%B8%EC%8A%A4%ED%84%B0%ED%94%BC%EC%9E%90&n_rank=1&n_ad_group=grp-a001-04-000000018430545&n_ad=nad-a001-04-000000146036306&n_keyword_id=nkw-a001-04-000003309565401&n_keyword=%EB%AF%B8%EC%8A%A4%ED%84%B0%ED%94%BC%EC%9E%90&n_campaign_type=4&n_contract=tct-a001-04-000000000416772&n_ad_group_type=5&NaPm=ct%3Dkssjkpeg%7Cci%3D0yK0003daMrv4hqHKvmF%7Ctr%3Dbrnd%7Chk%3Dead46c9fafdb8e9e276073d8c6c063a56582f866")  )
        mPizzaStores.add(  StoreData("도미노피자", "1577-3082", "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png", "https://cdn.dominos.co.kr/renewal2018/w/html/event/ad/210803/event.html?media=MTNB1_11&_C_=75506340&utm_campaign=Dominos_2108&utm_medium=display&utm_source=naver&utm_content=image&utm_term=8_main_harmony")  )

        mPizzaStoreAdapter = PizzaStoreAdapter(requireContext(), R.layout.store_list_item, mPizzaStores )
        pizzaStoreListView.adapter = mPizzaStoreAdapter


        pizzaStoreListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedPizzaStore = mPizzaStores[ position ]

            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("store", clickedPizzaStore)
            startActivity(myIntent)

        }


    }


}