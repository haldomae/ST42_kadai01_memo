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

data class MemoDataUiState(
    val memoCount: Int = 0,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class MemoViewModel: ViewModel() {
    // _countはViewModel内部だけ変更できる
    private val _uiState = MutableStateFlow(
        MemoDataUiState()
    )
    // Composeから読み取り専用
    val uiState : StateFlow<MemoDataUiState> = _uiState.asStateFlow()

    // 数値増やす処理(ボタンを押した時など)
    fun increment(){
        _uiState.value = _uiState.value.copy(
            memoCount = _uiState.value.memoCount + 1
        )
    }
}

@Composable
fun CounterScreenViewModel(
    viewModel: MemoViewModel = viewModel()){
    val uiState by viewModel.uiState.collectAsState()

    // フラグの参照
    if(uiState.isLoading){
        // ロード処理
    }

    // エラーメッセージの参照
    uiState.errorMessage?.let{ message ->
        Text(text = message)
    }

    Column {
        Text("データが保持されている: ${count.value}")
        Button(onClick = {viewModel.increment()}) {
            Text("+1")
        }
    }

}

