package com.rebecca.quizapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Question::class), version = 1, exportSchema = false)
abstract class QuestionDb : RoomDatabase() {
    abstract fun QuestionDao(): QuestionDao

    private class QuestionDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase){
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.QuestionDao())
                }
            }
        }
        suspend fun populateDatabase(questionDao: QuestionDao){
            questionDao.deleteAll()

            var question = Question(1,"1. What is Kotlin?","a","a. Java","b. Kotlin","c. none")
            questionDao.insert(question)
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: QuestionDb? = null

        fun getDatabase(context: Context, scope: CoroutineScope): QuestionDb {
            return INSTANCE ?: synchronized(this) {
                val  instance = Room.databaseBuilder(
                    context.applicationContext, QuestionDb::class.java,"question_database"
                ).addCallback(QuestionDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}