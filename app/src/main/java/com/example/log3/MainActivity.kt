package com.example.log3

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.log3.ui.theme.Log3Theme

class MainActivity : AppCompatActivity() {


    private var backPressedTime: Long = 0
    private val backPressThreshold: Long = 2000 // 두 번 눌러야 하는 시간 간격 (2초)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        var btn = findViewById<ImageButton>(R.id.logBtn)
        btn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
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