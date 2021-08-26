package com.example.pizzaorderapp_2021_08_25_9_39_home.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pizzaorderapp_2021_08_25_9_39_home.fragments.ChickenStoreListFragment
import com.example.pizzaorderapp_2021_08_25_9_39_home.fragments.MyProfileFragment
import com.example.pizzaorderapp_2021_08_25_9_39_home.fragments.PizzaStoreListFragment

class MainViewPagerAdapter( fm : FragmentManager ) : FragmentPagerAdapter(fm)  {

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "피자 주문"
            1 -> "치킨 주문"
            else -> "내 정보 설정"
    }}

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PizzaStoreListFragment()
            1 -> ChickenStoreListFragment()
            else -> MyProfileFragment()
        }
    }
}
