package com.saugatrai.wordapp

import android.content.Context
import androidx.lifecycle.LiveData

class WordRepository(context: Context) {
    private val wordDao: WordDao
    private val mAllWord: LiveData<MutableList<Word>>

    // get all words from database
    fun getAllWord(): LiveData<MutableList<Word>> {
        return mAllWord
    }

    fun insertWord(word: Word) {
        WordDatabase.Companion.executorService.execute(Runnable { wordDao.insertWord(word) })
    }

    init {
        val wordDatabase: WordDatabase = WordDatabase.getInstance(context)
        wordDao = wordDatabase.wordDao()
        mAllWord = wordDao.getAllWord()
    }
}