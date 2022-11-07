package com.jt17.tictactoe

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Game : AppCompatActivity() {
    var game_pos = 1
    var first_GRlist = mutableListOf<Int>()
    var second_GRlist = mutableListOf<Int>()
    lateinit var dialog: MaterialAlertDialogBuilder
    var click_color = true

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        change_color(R.color.blue_theme)

        val colors_setBTN = findViewById<MaterialCardView>(R.id.colors)
        val main_background = findViewById<RelativeLayout>(R.id.backgroundMAIN)

        colors_setBTN.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_ly, null)

            dialog = MaterialAlertDialogBuilder(this, R.style.MyCustomizedDialog)
                .setTitle("Change your color")
                .setView(view)
                .setNeutralButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    dialog.dismiss()
                }
                .setIcon(R.drawable.ic_round_color_lens_24)
            dialog.show()
        }

        findViewById<TextView>(R.id.first_gamer).setOnClickListener {
            val view = layoutInflater.inflate(R.layout.editxt_dialog_ly, null)

            dialog = MaterialAlertDialogBuilder(this, R.style.MyCustomizedDialog)
                .setTitle("enter your name")
                .setView(view)
                .setNeutralButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    findViewById<TextView>(R.id.first_gamer).text =
                        view.findViewById<EditText>(R.id.edit_name).text.toString()
                    dialog.dismiss()
                }
            dialog.show()
        }

        //Dialog for first gamer name
        findViewById<TextView>(R.id.first_gamer).setOnClickListener {
            val view = layoutInflater.inflate(R.layout.editxt_dialog_ly, null)

            dialog = MaterialAlertDialogBuilder(this, R.style.MyCustomizedDialog)
                .setTitle("enter your name")
                .setView(view)
                .setNeutralButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    findViewById<TextView>(R.id.first_gamer).text =
                        view.findViewById<EditText>(R.id.edit_name).text.toString()
                    dialog.dismiss()
                }
            dialog.show()
        }

        //Dialog for second gamer name
        findViewById<TextView>(R.id.second_gamer).setOnClickListener {
            val view = layoutInflater.inflate(R.layout.editxt_dialog_ly, null)

            dialog = MaterialAlertDialogBuilder(this, R.style.MyCustomizedDialog)
                .setTitle("Enter your name")
                .setView(view)
                .setNeutralButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    findViewById<TextView>(R.id.second_gamer).text =
                        view.findViewById<EditText>(R.id.edit_name).text.toString()
                    dialog.dismiss()
                }
            dialog.show()
        }

    }

    companion object {
        var count1 = 0
        var count2 = 0
    }

    private fun change_color(set_col: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(set_col)
        }
    }

    fun onClick(view: View) {
        val btn_Select: Button = view as Button
        var btn_Numb = 0
        when (btn_Select.id) {
            R.id.btn_1 -> btn_Numb = 1
            R.id.btn_2 -> btn_Numb = 2
            R.id.btn_3 -> btn_Numb = 3

            R.id.btn_4 -> btn_Numb = 4
            R.id.btn_5 -> btn_Numb = 5
            R.id.btn_6 -> btn_Numb = 6

            R.id.btn_7 -> btn_Numb = 7
            R.id.btn_8 -> btn_Numb = 8
            R.id.btn_9 -> btn_Numb = 9
        }
        startGame(btn_Numb, btn_Select)
    }

    //uyin boshlanishi uchun
    private fun startGame(btn_Num: Int, btn: Button) {
        if (game_pos == 1) {
            btn.text = "X"
            this.game_pos = 2
            first_GRlist.add(btn_Num)
        } else {
            btn.text = "0"
            this.game_pos = 1
            second_GRlist.add(btn_Num)
        }
        btn.isEnabled = false
        checkWinner()
    }

    //Winnerni aniqlash
    @SuppressLint("ResourceAsColor")
    private fun checkWinner() {
        var winner = 0

        //1 - qator
        if (first_GRlist.contains(1) && first_GRlist.contains(2) && first_GRlist.contains(3)) {
            winner = 1

        }
        if (second_GRlist.contains(1) && second_GRlist.contains(2) && second_GRlist.contains(3)) {
            winner = 2
        }

        //2 - qator
        if (first_GRlist.contains(4) && first_GRlist.contains(5) && first_GRlist.contains(6)) {
            winner = 1
        }
        if (second_GRlist.contains(4) && second_GRlist.contains(5) && second_GRlist.contains(6)) {
            winner = 2
        }

        //3 - qator
        if (first_GRlist.contains(7) && first_GRlist.contains(8) && first_GRlist.contains(9)) {
            winner = 1
        }
        if (second_GRlist.contains(7) && second_GRlist.contains(8) && second_GRlist.contains(9)) {
            winner = 2
        }

        //1 - ustun
        if (first_GRlist.contains(1) && first_GRlist.contains(4) && first_GRlist.contains(7)) {
            winner = 1
        }
        if (second_GRlist.contains(1) && second_GRlist.contains(4) && second_GRlist.contains(7)) {
            winner = 2
        }

        //2 - ustun
        if (first_GRlist.contains(2) && first_GRlist.contains(5) && first_GRlist.contains(8)) {
            winner = 1
        }
        if (second_GRlist.contains(2) && second_GRlist.contains(8) && second_GRlist.contains(9)) {
            winner = 2
        }

        //3 - ustun
        if (first_GRlist.contains(3) && first_GRlist.contains(6) && first_GRlist.contains(9)) {
            winner = 1
        }
        if (second_GRlist.contains(3) && second_GRlist.contains(6) && second_GRlist.contains(9)) {
            winner = 2
        }

        //1 - diagonal
        if (first_GRlist.contains(1) && first_GRlist.contains(5) && first_GRlist.contains(9)) {
            winner = 1
        }
        if (second_GRlist.contains(1) && second_GRlist.contains(5) && second_GRlist.contains(9)) {
            winner = 2
        }

        //2 - diagonal
        if (first_GRlist.contains(3) && first_GRlist.contains(5) && first_GRlist.contains(7)) {
            winner = 1
        }
        if (second_GRlist.contains(3) && second_GRlist.contains(5) && second_GRlist.contains(7)) {
            winner = 2
        }

        if (winner != 0) {
            val str = findViewById<TextView>(R.id.yutti)
            val player1sc = findViewById<TextView>(R.id.player1s_score)
            val player2sc = findViewById<TextView>(R.id.player2s_score)

            if (game_pos == 1) {
                str.text = "0 yutti"
                str.visibility = View.VISIBLE
                count1++

                player2sc.text = count1.toString()
                stopTouch()
            } else {
                str.text = "X yutti"
                str.visibility = View.VISIBLE
                count2++

                player1sc.text = count2.toString()
                stopTouch()
            }
        }

    }

    //Uyin tugaganidan keyin tegisnishni
    private fun stopTouch() {


        findViewById<Button>(R.id.btn_1).isEnabled = false
        findViewById<Button>(R.id.btn_2).isEnabled = false
        findViewById<Button>(R.id.btn_3).isEnabled = false

        findViewById<Button>(R.id.btn_4).isEnabled = false
        findViewById<Button>(R.id.btn_5).isEnabled = false
        findViewById<Button>(R.id.btn_6).isEnabled = false

        findViewById<Button>(R.id.btn_7).isEnabled = false
        findViewById<Button>(R.id.btn_8).isEnabled = false
        findViewById<Button>(R.id.btn_9).isEnabled = false
    }

    //refresh game
    @SuppressLint("CutPasteId")
    fun refresh(view: View) {

        val b1 = findViewById<Button>(R.id.btn_1)
        val b2 = findViewById<Button>(R.id.btn_2)
        val b3 = findViewById<Button>(R.id.btn_3)
        val b4 = findViewById<Button>(R.id.btn_4)
        val b5 = findViewById<Button>(R.id.btn_5)
        val b6 = findViewById<Button>(R.id.btn_6)
        val b7 = findViewById<Button>(R.id.btn_7)
        val b8 = findViewById<Button>(R.id.btn_8)
        val b9 = findViewById<Button>(R.id.btn_9)
        val str = findViewById<TextView>(R.id.yutti)


        b1.text = ""
        b2.text = ""
        b3.text = ""

        b4.text = ""
        b5.text = ""
        b6.text = ""

        b7.text = ""
        b8.text = ""
        b9.text = ""

        str.visibility = View.INVISIBLE

        first_GRlist.clear()
        second_GRlist.clear()

        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true

        b4.isEnabled = true
        b5.isEnabled = true
        b6.isEnabled = true

        b7.isEnabled = true
        b8.isEnabled = true
        b9.isEnabled = true

        game_pos = 1
    }

    fun blue_themed(view: View) {
        val main_background = findViewById<RelativeLayout>(R.id.backgroundMAIN)

        main_background.setBackgroundResource(R.drawable.game_bckg)
        change_color(R.color.blue_theme)
    }

    fun red_themed(view: View) {
        val main_background = findViewById<RelativeLayout>(R.id.backgroundMAIN)

        main_background.setBackgroundResource(R.drawable.game_bckg_red)
        change_color(R.color.red_theme)
    }

    fun green_themed(view: View) {
        val main_background = findViewById<RelativeLayout>(R.id.backgroundMAIN)

        main_background.setBackgroundResource(R.drawable.game_bckg_green)
        change_color(R.color.gree_theme)
    }

    fun yellow_themed(view: View) {
        val main_background = findViewById<RelativeLayout>(R.id.backgroundMAIN)

        main_background.setBackgroundResource(R.drawable.game_bckg_yellow)
        change_color(R.color.yellow_theme)
    }

}