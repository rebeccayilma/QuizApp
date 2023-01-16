package com.rebecca.quizapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Question::class), version = 1, exportSchema = false)
public abstract class QuestionDb : RoomDatabase() {
    abstract fun QuestionDao(): QuestionDao

    companion object{
        @Volatile
        private var INSTANCE: QuestionDb? = null

        fun getDatabase(context: Context): QuestionDb {
            return INSTANCE ?: synchronized(this) {
                val  instance = Room.databaseBuilder(
                    context.applicationContext, QuestionDb::class.java,"question_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}