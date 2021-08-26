package com.neppplus.pizzaorderapppractice_20210826_13_13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        okBtn.setOnClickListener {
            val inputNickname = newNicknameEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nickname", inputNickname)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    override fun setValues() {
    }

}