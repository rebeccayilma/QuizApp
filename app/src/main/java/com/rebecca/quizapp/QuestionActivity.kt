package com.rebecca.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.viewModels

class QuestionActivity : AppCompatActivity() {
    private val questionViewModel : QuestionViewModel by viewModels {
        QuestionViewModelFactory((application as QuestionsApplication).repository)
    }
    var count = 0
    val qlist:Question  =   questionViewModel.allQuestions.get(count)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        

        val question_txt : TextView = findViewById(R.id.question_txt)
        val opt1 : RadioButton = findViewById(R.id.opt1)
        val opt2 : RadioButton = findViewById(R.id.opt2)
        val opt3 : RadioButton = findViewById(R.id.opt3)
        val nextBtn : TextView = findViewById(R.id.next_btn)
        val homeBtn : TextView = findViewById(R.id.home_btn)
        val radioGroup : RadioGroup = findViewById(R.id.radioGroup)

        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        question_txt.setText(qlist.question)
        opt1.setText(qlist.opt1)
        opt2.setText(qlist.opt2)
        opt3.setText(qlist.opt3)


        nextBtn.setOnClickListener{
            val selectedOption: Int = radioGroup!!.checkedRadioButtonId

                count ++


        }


    }
}