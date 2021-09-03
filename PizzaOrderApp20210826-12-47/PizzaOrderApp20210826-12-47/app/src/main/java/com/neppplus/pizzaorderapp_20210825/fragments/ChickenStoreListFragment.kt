package com.neppplus.pizzaorderapp_20210825.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp_20210825.R
import com.neppplus.pizzaorderapp_20210825.ViewChickenStoreDetailActivity
import com.neppplus.pizzaorderapp_20210825.ViewStoreDetailActivity
import com.neppplus.pizzaorderapp_20210825.adapters.ChickenStoreAdapter
import com.neppplus.pizzaorderapp_20210825.adapters.PizzaStoreAdapter
import com.neppplus.pizzaorderapp_20210825.datas.StoreData
import com.neppplus.pizzaorderapp_20210825.datas.StoreData_chicken
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*
import kotlinx.android.synthetic.main.fragment_pizza_store_list.pizzaStoreListView

class ChickenStoreListFragment : Fragment() {

    val mChickenStores = ArrayList<StoreData_chicken>()
    lateinit var mChickenStoreAdapter : ChickenStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate( R.layout.fragment_chicken_store_list, container, false )
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mChickenStores.add(StoreData_chicken("60계 치킨 부천상동점", "1566-3366", "" + "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA4MThfMzcg%2FMDAxNjI5MjQ4NjUwMjA5.p7QhuwxYSgN7V9Mc1wHv1EJ9f45f6MjvlN596PYIUzAg.v0Al6DpXJNBkVsi0iDt77bmH_yANf4jA-apL192njI0g.JPEG.guseule%2FIMG_7272.jpg&type=a340"))
        mChickenStores.add(StoreData_chicken("교촌치킨 상동역점", "1577-1991", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA4MTFfMTkx%2FMDAxNjI4NjgyNTAyMjYw.Su8GW6wPc5fXRvrWtrziAmaFaRSAn8dO5hp9eZXfHA8g.g_P5NCC3pleG6RPbLyRE8eqKhK86zqu5mm3quVy4iLIg.JPEG.seyoung1916%2FIMG_4258.jpg&type=a340"))
        mChickenStores.add(StoreData_chicken("푸라닭", "1599-9206", "" + "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA1MDJfNCAg%2FMDAxNjE5OTI0Nzc3Nzg0.bQe7P_paf9O4ggCBvpQ6fX8avH01xsBCX7OAm0uQV_Qg.inxw-pdDS51lLt6f3xEBLnbdzZVK_MJkG0Wdfm1jGNkg.JPEG.bonita1014%2F21%25A3%25AD05%25A3%25AD02%25A3%25AD12%25A3%25AD05%25A3%25AD57%25A3%25AD444%25A3%25DFdeco.jpg&type=a340"))
        mChickenStores.add(StoreData_chicken("강정이기가막혀", "1544-3192", "" + "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMTVfMTMy%2FMDAxNjEwNzAwOTcyNTk3.DHf29NArKYtCoNvF7W4JTAvAuWZwKilsqYZii2LvSXIg.31lT0dUu3ERj-lqzEenAsi2uiNqNA1wP9KOUhWQtzZAg.JPEG.dudurd9398%2FIMG_1567.jpg&type=a340"))

        mChickenStoreAdapter = ChickenStoreAdapter(requireContext(), R.layout.store_list_item_chicken, mChickenStores )
        chickenStoreListView.adapter = mChickenStoreAdapter


        chickenStoreListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedChickenStore = mChickenStores[ position ]

            val myIntent = Intent(requireContext(), ViewChickenStoreDetailActivity::class.java)
            myIntent.putExtra("store_chicken", clickedChickenStore)
            startActivity(myIntent)

        }
    }
}