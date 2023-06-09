package com.example.log3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Main_login : ComponentActivity() {

    private var backPressedTime: Long = 0
    private val backPressThreshold: Long = 2000 // 두 번 눌러야 하는 시간 간격 (2초)
    private val TAG = "Main_login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        var recent = findViewById<TextView>(R.id.recent_party)
        var userBtn = findViewById<ImageButton>(R.id.user)

        userBtn.setOnClickListener {
            val intent = Intent(this, Mypage::class.java)
            startActivity(intent)
        }

    }
    override fun onBackPressed() {
        if (System.currentTimeMillis() - backPressedTime < backPressThreshold) {
            super.onBackPressed()
            finishAffinity()
            System.exit(0)
        } else {
            Toast.makeText(this, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
            backPressedTime = System.currentTimeMillis()
        }
    }
}