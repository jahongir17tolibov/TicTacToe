package com.jt17.tictactoe

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView


class MainActivity : AppCompatActivity() {
    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.main_page)
        }

        findViewById<MaterialCardView>(R.id.Start_btn).setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        findViewById<MaterialCardView>(R.id.exit_btn).setOnClickListener {
            finish()
        }

    }
}