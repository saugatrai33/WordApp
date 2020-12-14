package com.saugatrai.wordapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {
    @Query("SELECT * FROM tbl_word ORDER BY word DESC")
    open fun getAllWord(): LiveData<MutableList<Word>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    open fun insertWord(word: Word)
}