package com.rebecca.quizapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(question:Question)

    @Query("SELECT * FROM questions_table ORDER BY question DESC")
    fun getAllQuestions(): List<Question>

    @Query("DELETE FROM questions_table")
    fun deleteAll()

}