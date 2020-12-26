package com.seminlee.tic_tac_toe2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val textView = findViewById<believe.cht.fadeintextview.TextView>(R.id.textView)
        textView.setLetterDuration(150)
        textView.text = "WELCOME TO TIC-TAC-TOE!"
        textView.isAnimating

        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            val intent1 = Intent( this, SinglePlayerActivity1::class.java)

            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            val intent2 = Intent( this, TwoPlayerActivity1::class.java)

            startActivity(intent2)
        }
    }
}
