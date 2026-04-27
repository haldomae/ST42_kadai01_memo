package com.classnumber_00_domaekazuki.st42_kadai01_sample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun AddScreen(
    onNavigateBack: () -> Unit

){
    Column{
        Text(text = "戻る")
        Button(
            onClick = onNavigateBack
        ) {
            Text(text = "戻る")
        }
    }

}