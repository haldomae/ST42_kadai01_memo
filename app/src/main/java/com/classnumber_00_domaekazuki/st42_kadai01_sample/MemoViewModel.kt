package com.classnumber_00_domaekazuki.st42_kadai01_sample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MemoViewModel: ViewModel() {
    // _countはViewModel内部だけ変更できる
    private val _count = MutableStateFlow(0)
    // Composeから読み取り専用
    val count : StateFlow<Int> = _count.asStateFlow()

    // 数値増やす処理(ボタンを押した時など)
    fun increment(){
        _count.value++
    }
}

@Composable
fun CounterScreenViewModel(
    viewModel: MemoViewModel = viewModel()){
    // countの値が変わるとComposeが再描画される
    val count = viewModel.count.collectAsState()
    Column {
        Text("データが保持されている: ${count.value}")
        Button(onClick = {viewModel.increment()}) {
            Text("+1")
        }
    }

}

