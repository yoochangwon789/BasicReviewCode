package com.yoochangwonspro.basicreviewcode

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoochangwonspro.basicreviewcode.dao.HistoryDao
import com.yoochangwonspro.basicreviewcode.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}