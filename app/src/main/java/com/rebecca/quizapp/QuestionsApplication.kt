package com.rebecca.quizapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class QuestionsApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { QuestionDb.getDatabase(this, applicationScope) }
    val repository by lazy { QuestionRepository(database.QuestionDao()) }


}