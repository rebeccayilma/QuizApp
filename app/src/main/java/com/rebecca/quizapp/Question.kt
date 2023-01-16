package com.rebecca.quizapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions_table")
data class Question(@PrimaryKey(autoGenerate = true) val id: Int, @ColumnInfo(name = "question") val question:String, @ColumnInfo(name = "answer") val answer:String,@ColumnInfo(name = "opt1") val opt1:String, @ColumnInfo(name = "opt2") val opt2:String, @ColumnInfo(name = "opt3")val opt3: String) {
}