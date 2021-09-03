package com.neppplus.phonebook_20210902.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.neppplus.phonebook_20210902.R
import com.neppplus.phonebook_20210902.datas.PhoneNumData

class PhoneNumAdapter(
    val mContext : Context,
    resId : Int,
    val mList : List<PhoneNumData>) : ArrayAdapter<PhoneNumData>(mContext, resId, mList) {

    private val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        getView : xml (우리가 만든 xml로 커스텀) -> position에 맞는 데이터를 입혀서 -> 리스트뷰의 각 position에 뿌려주기.

        var row = convertView
        if (row == null) {
            row = mInflater.inflate(R.layout.phone_num_list_item, null)
        }

//        row!!  // 이미 row는 무조건 null 아니라고 우김.

//        이 밑으로는 row는 null이 아닌걸로 칠.
        val nameTxt = row!!.findViewById<TextView>(R.id.nameTxt)
        val birthDayTxt = row.findViewById<TextView>(R.id.birthDayTxt)
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNumTxt)
        val dialImg = row.findViewById<ImageView>(R.id.dialImg)

//        폰번 데이터 꺼내오자.
        val data = mList.get(position)

        nameTxt.text = data.name
        phoneNumTxt.text = data.phoneNum

//        nameTxt.setText( data.getName() )

//        폰번데이터의 생년월일 (Calendar)을 -> 5월 8일 양식으로 가공 (String) 하는 방법.
        birthDayTxt.text = data.getFormattedBirthday()


//        이미지뷰에 클릭이벤트 부여.
        dialImg.setOnClickListener {

//            DIAL 액션 Intent 활용

            val myUri = Uri.parse("tel:${data.phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

//            어댑터 안에서, 액티비티의 기능인 startActivity 함수를 실행하고 싶다.
//            어댑터를 만들때 -> 화면 정보를 받아옴. mContext변수에 받아옴.

//            전달받은 mContext의 기능 활용.
            mContext.startActivity(myIntent)

        }

        return row

    }

}