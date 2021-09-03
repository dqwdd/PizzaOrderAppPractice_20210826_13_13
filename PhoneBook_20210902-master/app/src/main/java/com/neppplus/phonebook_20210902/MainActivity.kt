package com.neppplus.phonebook_20210902

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.neppplus.phonebook_20210902.adapters.PhoneNumAdapter
import com.neppplus.phonebook_20210902.datas.PhoneNumData
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.text.SimpleDateFormat

class MainActivity : BaseActivity() {

    val mPhoneNumList = ArrayList<PhoneNumData>()

//    1. 멤버변수로 빼는게 편하다.
//    2. 초기화 할때 화면정보 (Context)가 필요한가? => 필요하다 : onCreate 내부 or 이후 에서 대입.
//     Hint : JAVA에서 배우는 클래스들 -> 대부분 화면 필요 X. val로 만들어도 된다.
    lateinit var mAdapter : PhoneNumAdapter

//    0. 전화번호 추가 기능 -> 별도 화면에서 저장시키자.

//    1. 화면에 들어오면 -> 파일에 저장된 "이름,폰번,1988-05-05" 문장을 불러내자.
//     안드로이드에서 파일 다루는법? + String 분리 / UserData 변환 등등.

//    2. 불러낸 데이터들을 -> 리스트뷰에 뿌려주자. (리스트뷰 사용법)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        addPhoneNumBtn.setOnClickListener {
//            자바의 인터페이스를 개량한 버젼의 코드.

//            EditPhoneNumActivity 로 이동 : Intent

            val myIntent = Intent(mContext, EditPhoneNumActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

//        임시방편 : 직접 리스트에 데이터 객체 추가.

//        mPhoneNumList.add( PhoneNumData("테스트1", "010-1111-2222") )
//        mPhoneNumList.add( PhoneNumData("테스트2", "010-3333-4444") )
//        mPhoneNumList.add( PhoneNumData("테스트3", "010-5555-6666") )


//        어댑터 초기화.
        mAdapter = PhoneNumAdapter(mContext, R.layout.phone_num_list_item, mPhoneNumList)

//        리스트뷰의 어댑터로 연결
        phoneNumListView.adapter = mAdapter



//        수정방안 -> 파일을 불러와서, 그 내용을 읽고 -> PhoneNumDate()로 변환. -> 목록에 추가.

        readPhoneBookFromFile()



    }


    override fun onResume() {
        super.onResume()

//        파일에서 폰번을 화면에 올때마다 새로 읽어주자.
        readPhoneBookFromFile()

    }

//    파일에서 폰번 읽어와서 -> 폰번목록에 추가.

    fun readPhoneBookFromFile() {

        val myFile = File(filesDir, "phoneBook.txt")

        val fr = FileReader(myFile)
        val br = BufferedReader(fr)

//        1991-05-08 String을 분석하는데 쓰일 양식.
        val sdf = SimpleDateFormat("yyyy-MM-dd")

//        이 코드는 반복 실행되면 데이터가 누적으로 쌓인다.
//        기존에 있던 폰번은 날리고 -> 새로 데이터 담아주자.
        mPhoneNumList.clear()

        while (true) {

            val line = br.readLine()

            if (line == null) {

//                읽어온 내용이 없다면 -> 종료.
                break
            }

            Log.d("읽어온 한줄", line)

//            읽어온 line을 => , 기준으로 분리.

            val infos = line.split(",")

//            이름, 폰번만 우선 폰번데이터로.
            val phoneNumData = PhoneNumData(infos[0], infos[1])

//            phoneNumData 의 생년월일을, 실제 입력한 생년월일로.
//            "1991-05-09" 로 분리된 String을 기반으로 => phoneNumData의 일자로 저장. =>  (String -> Calendar)
//            SimpleDateFormat의  parse 기능 활용.

            phoneNumData.birthDay.time = sdf.parse(infos[2])

//            만들어진 폰번 데이터 목록에 추가.
            mPhoneNumList.add(phoneNumData)


        }

        br.close()
        fr.close()

//        목록에 내용물이 추가됨. -> 리스트뷰도 인지해야함.
        mAdapter.notifyDataSetChanged()

    }

}