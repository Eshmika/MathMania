package com.example.mathmania

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class score_page : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences("GamePreferences", Context.MODE_PRIVATE)
        val gameResultTextView = findViewById<TextView>(R.id.scorelist)

        // Check if "game_result" exists in SharedPreferences
        val gameResult = sharedPreferences.getString("game_result", "")

        // Check if "game_result" is not empty and display it
        if (!gameResult.isNullOrEmpty()) {
            gameResultTextView.text = "$gameResult"

        }

        val backButton = findViewById<Button>(R.id.bck_button)
        backButton.setOnClickListener {
            var intent = Intent(this,mainmenu::class.java)
            startActivity(intent)
            finish()

        }

    }
}