package com.classnumber_00_domaekazuki.st42_kadai01_sample

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Add: Screen("add")
    // 引数付きルート
    object Detail: Screen("detail/{taskId}")
}