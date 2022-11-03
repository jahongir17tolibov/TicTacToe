package com.jt17.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialCardView>(R.id.Start_btn).setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        findViewById<MaterialCardView>(R.id.exit_btn).setOnClickListener {
            finish()
        }

    }
}