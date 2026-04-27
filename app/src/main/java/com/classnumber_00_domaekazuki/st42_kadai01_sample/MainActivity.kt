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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.classnumber_00_domaekazuki.st42_kadai01_sample.ui.theme.ST42_kadai01_sampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ST42_kadai01_sampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    CounterScreen()
//                    CounterScreenViewModel()
                    AppNavigation()
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

@Composable
fun AppNavigation(){
    // NaVControllerを作成
    // 画面遷移を命令する
    val navController = rememberNavController()

    // NavHostで画面とRouteを紐づける
    NavHost(
        // ナビコントローラー
        navController = navController,
        // 最初に表示する画面
        startDestination = "home"
    ){
        // 各画面を用意
        composable("home") {
            HomeScreen(
                onNavigateToAdd = {
                    // 指定した画面に進む
                    navController.navigate("add")
                }
            )
        }
        composable("add") {
            AddScreen(
                onNavigateBack = {
                    // 画面戻る
                    navController.popBackStack()
                }
            )
        }
    }
}