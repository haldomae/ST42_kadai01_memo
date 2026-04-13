package com.classnumber_00_domaekazuki.st42_kadai01_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.classnumber_00_domaekazuki.st42_kadai01_sample.ui.theme.ST42_kadai01_sampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ST42_kadai01_sampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    CounterScreen()
                    CounterScreenViewModel()
                }
            }
        }
    }
}

// 数値増やす関数(画面回転で消える)
@Composable
fun CounterScreen(){
    // 増える値が格納されている変数
    var count by remember {
        mutableStateOf(0)
    }

    // ボタン押したら値が増える
    Column {
        Text(text = "カウント: ${count}")
        Button(
            onClick = {count++}
        ) {
            Text("+1")
        }
    }
}