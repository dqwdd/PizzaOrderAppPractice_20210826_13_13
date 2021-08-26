package com.example.pizzaorderapp_2021_08_25_9_39_home.fragments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaorderapp_2021_08_25_9_39_home.EditNicknameActivity
import com.example.pizzaorderapp_2021_08_25_9_39_home.R
import kotlinx.android.synthetic.main.fragment_myprofilefragment.*

class MyProfileFragment : Fragment() {

    val REQ_FOR_NICKNAME = 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?) : View?{
        return inflater.inflate(R.layout.fragment_myprofilefragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        moveEditNickname.setOnClickListener {
            val myIntent = Intent(requireContext(), EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
//            그냥 인텐트가 아니라 포 리절트임 REQ_FOR_NICKNAME도 선언
        }

//        nickNameTxt.text = roomData.address



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==REQ_FOR_NICKNAME) {
            if (requestCode== Activity.RESULT_OK) {
                val newNickname = data!!.getStringExtra("nickname")
                nickNameTxt.text=newNickname
            }
        }

    }
}