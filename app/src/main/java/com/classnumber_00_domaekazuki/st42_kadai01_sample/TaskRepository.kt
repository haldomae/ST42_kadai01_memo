package com.classnumber_00_domaekazuki.st42_kadai01_sample

import kotlinx.coroutines.flow.Flow


// ViewModel -> Repository -> Dao -> Database
// の設計が一般的
// ViewModelがデータの取得元(DB,API)を意識しなくてもよくなる
// テストがしやすくなる
// データソースを後から変更しやすい
class TaskRepository(private val taskDao: TaskDao) {
    // 全件取得
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    // 追加
    suspend fun insert(task: Task) {
        taskDao.insertTask(task)
    }
    // 更新
    suspend fun update(task: Task) {
        taskDao.updateTask(task)
    }
    // 削除
    suspend fun delete(task: Task){
        taskDao.deleteTask(task)
    }

}