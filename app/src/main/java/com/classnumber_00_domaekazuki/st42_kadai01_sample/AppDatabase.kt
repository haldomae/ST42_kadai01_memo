package com.classnumber_00_domaekazuki.st42_kadai01_sample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    // このDBが管理するテーブル一覧
    entities = [Task::class],
    // DBのバージョン(DBの変更を行ったらバージョンを上げる)
    version = 1,
    exportSchema = false
)
// 抽象クラスにはabstractを付ける
abstract class AppDatabase: RoomDatabase() {
    // Daoを取得する為の関数
    abstract fun taskDao(): TaskDao

    // アプリ全体でDBのインスタンスが1つだけになる(シングルトン)
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}