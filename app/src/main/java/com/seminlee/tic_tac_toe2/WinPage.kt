package com.seminlee.tic_tac_toe2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WinPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_page)

        supportActionBar?.hide()
        val fromPreviousActivity = intent.extras
        val activityId = fromPreviousActivity?.getString("winner")

        val tv1 = findViewById<believe.cht.fadeintextview.TextView>(R.id.textView)
        tv1.setLetterDuration(150)
        tv1.text = activityId
        tv1.isAnimating

        val yesBtn = findViewById<Button>(R.id.button)
        val noBtn = findViewById<Button>(R.id.button1)

        yesBtn.setOnClickListener {
//            super.onBackPressed()
            val intent = Intent(this, TwoPlayerActivity1::class.java)
            startActivity(intent)
            finish()
        }
        noBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}