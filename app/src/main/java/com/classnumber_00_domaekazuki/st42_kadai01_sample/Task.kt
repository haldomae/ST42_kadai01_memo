package com.classnumber_00_domaekazuki.st42_kadai01_sample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val isDone: Boolean = false
)
