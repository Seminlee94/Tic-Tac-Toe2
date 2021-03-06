package com.seminlee.tic_tac_toe2

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second2.*
import kotlin.collections.ArrayList

class TwoPlayerActivity1 : AppCompatActivity() {

    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        return@OnNavigationItemSelectedListener when (menuItem.itemId) {
            R.id.ic_home -> {
                startActivity(Intent( this, MainActivity::class.java))
                finish()
                true
            }
            R.id.ic_person -> {
                startActivity(Intent( this, SinglePlayerActivity1::class.java))
                finish()
                true
            }
            else -> true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player)

        supportActionBar?.hide()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigation)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun btnClick(view: View){
        val btnSelected = view as Button


        var cellID = 0
        when(btnSelected.id){
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
        playGame(cellID, btnSelected)
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1
    private var player1name = "player 1"
    private var player2name = "player 2"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun playGame(cellID: Int, btnSelected: Button) {
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)

        if(activePlayer == 1){
            btnSelected.text = "X"
            btnSelected.backgroundTintList = ColorStateList.valueOf(0xFF000000.toInt())
            btnSelected.setTextColor(Color.parseColor("#FFC107"))
            player1.add(cellID)
            textView3.setTextColor(Color.WHITE)
            textView4.setTextColor(Color.parseColor("#FFC107"))
            activePlayer = 2
        } else {
            btnSelected.text = "O"
            btnSelected.backgroundTintList = ColorStateList.valueOf(0xFF000000.toInt())
            btnSelected.setTextColor(Color.parseColor("#FFBB86FC"))
            player2.add(cellID)
            textView3.setTextColor(Color.parseColor("#FFC107"))
            textView4.setTextColor(Color.WHITE)
            activePlayer = 1
        }

        btnSelected.isEnabled = false
        val player1size = player1.size
        val player2size = player2.size
        checkWinner(player1size, player2size, player1name, player2name)

    }


    private fun checkWinner(player1size: Int, player2size: Int, player1name: String, player2name: String) {
        val winner: Int = when {
            player1.contains(1) && player1.contains(2) && player1.contains(3) -> 1
            player1.contains(4) && player1.contains(5) && player1.contains(6) -> 1
            player1.contains(7) && player1.contains(8) && player1.contains(9) -> 1
            player1.contains(1) && player1.contains(4) && player1.contains(7) -> 1
            player1.contains(2) && player1.contains(5) && player1.contains(8) -> 1
            player1.contains(3) && player1.contains(6) && player1.contains(9) -> 1
            player1.contains(1) && player1.contains(5) && player1.contains(9) -> 1
            player1.contains(3) && player1.contains(5) && player1.contains(7) -> 1
            player2.contains(1) && player2.contains(2) && player2.contains(3) -> 2
            player2.contains(4) && player2.contains(5) && player2.contains(6) -> 2
            player2.contains(7) && player2.contains(8) && player2.contains(9) -> 2
            player2.contains(1) && player2.contains(4) && player2.contains(7) -> 2
            player2.contains(2) && player2.contains(5) && player2.contains(8) -> 2
            player2.contains(3) && player2.contains(6) && player2.contains(9) -> 2
            player2.contains(1) && player2.contains(5) && player2.contains(9) -> 2
            player2.contains(3) && player2.contains(5) && player2.contains(7) -> 2
            else -> -1
        }


        if((player1size + player2size == 9) && (winner != 1 || winner != 2)){
            val intent1 = Intent( this, WinPage::class.java)
            intent1.putExtra("winner", "Game is tied!")
            startActivity(intent1)
            finish()
        }

        if(winner == 1 || winner == 2){
            for (i in 1..9)
            {
                val id:Int = resources.getIdentifier("button$i","id", packageName)
                val btn:Button = findViewById(id)
                btn.isClickable = false
            }
            if(winner == 1){

                val intent1 = Intent( this, WinPage::class.java)
                intent1.putExtra("winner", "$player1name won the game")
                startActivity(intent1)
                finish()
            } else {
                val intent1 = Intent( this, WinPage::class.java)
                intent1.putExtra("winner", "$player2name won the game")
                startActivity(intent1)
                finish()
            }
        }
    }
}