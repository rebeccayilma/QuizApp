package com.rebecca.quizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class QuestionViewModel(private val repository: QuestionRepository) : ViewModel() {

    val allQuestions: List<Question> = repository.allQuestions

    fun insert(question: Question) = viewModelScope.launch {
        repository.insert(question)
    }
}

class QuestionViewModelFactory(private val repository: QuestionRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return QuestionViewModel(repository) as T
        }
        throw IllegalArgumentException(" Unknown ViewModel class")
    }
}