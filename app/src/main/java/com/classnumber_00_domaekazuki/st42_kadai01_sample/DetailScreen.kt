package com.classnumber_00_domaekazuki.st42_kadai01_sample

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(
    taskId: Int?,
    onNavigateBack: () -> Unit,
) {
    Text(text = "タスクID: $taskId")
}
