package com.classnumber_00_domaekazuki.st42_kadai01_sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onNavigateToAdd: () -> Unit,
) {
    Column {
        Text(text = "Addへ進む")
        Button(
            onClick = onNavigateToAdd
        ) {
            Text("Addへ進む")
        }
    }

}