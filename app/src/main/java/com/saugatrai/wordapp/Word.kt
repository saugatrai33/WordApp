package com.saugatrai.wordapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_word")
class Word(mWord: String) {
    @PrimaryKey
    @ColumnInfo(name = "word")
    private val mWord: String
    fun getWord(): String? {
        return mWord
    }

    init {
        this.mWord = mWord
    }
}