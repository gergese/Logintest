package com.example.log3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.log3.ui.theme.Log3Theme

class Mypage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        var test = findViewById<TextView>(R.id.tv_test)
        var noticeBtn = findViewById<Button>(R.id.btn_notice)

        //임시 저장한 사용자 이메일 불러오기
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val emailAddr = sharedPreferences.getString("email", "")

        test.text = emailAddr

        noticeBtn.setOnClickListener {
            intent = Intent(this, Notice :: class.java)
            startActivity(intent)
        }
    }
}