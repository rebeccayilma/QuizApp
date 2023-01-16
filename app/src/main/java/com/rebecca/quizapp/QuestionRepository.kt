package com.rebecca.quizapp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class QuestionRepository(private val questionDao: QuestionDao) {

    val allQuestions: Flow<List<Question>> = questionDao.getAllQuestions()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(question: Question){
        questionDao.insert(question)
    }
}