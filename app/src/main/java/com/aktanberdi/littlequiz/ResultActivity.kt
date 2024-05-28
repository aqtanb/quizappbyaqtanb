package com.aktanberdi.littlequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName : TextView = findViewById(R.id.tvName)
        val tvResult : TextView = findViewById(R.id.tvResult)
        val btnFinish : Button = findViewById(R.id.btnFinish)

        userName.text = intent.getStringExtra(Constants.USER_NAME)

        val total = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correct = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)


        tvResult.text = "Ваш результат $correct из $total"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}