package com.saugatrai.wordapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class WordViewModel(context: Context) : ViewModel() {
    private val repository: WordRepository
    private val mAllWords: LiveData<MutableList<Word>>
    fun getAllWords(): LiveData<MutableList<Word>> {
        return mAllWords
    }

    fun insertWord(word: Word) {
        repository.insertWord(word)
    }

    init {
        repository = WordRepository(context)
        mAllWords = repository.getAllWord()
    }
}