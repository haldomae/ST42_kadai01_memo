package com.classnumber_00_domaekazuki.st42_kadai01_sample

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    // CRUD(DB操作)
    // 全件取得(FLOWは最新状態を取得)
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): Flow<List<Task>>

    // 1件取得
    @Query("SELECT * FROM tasks WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int): Task?

    // 追加
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    // 更新
    @Update
    suspend fun updateTask(task: Task)

    // 削除
    @Delete
    suspend fun deleteTask(task: Task)
}