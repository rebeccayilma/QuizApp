package com.rebecca.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {
//    private val questionViewModel : QuestionViewModel by viewModels<Question> {
//        QuestionViewModelFactory((application as QuestionsApplication).repository)
//    }
//    private val questionViewModel : QuestionViewModel by viewModels {
//        QuestionViewModelFactory((application as QuestionsApplication).repository)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView : ImageView = findViewById(R.id.start_img)
        imgView.setImageResource(R.drawable.choice)

        val startBtn : Button = findViewById(R.id.start)
        startBtn.setOnClickListener{
            val intent = Intent(this,QuestionActivity::class.java)
            startActivity(intent)
        }

    }
}

