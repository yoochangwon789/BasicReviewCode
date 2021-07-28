package com.yoochangwonspro.basicreviewcode.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yoochangwonspro.basicreviewcode.model.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()
}