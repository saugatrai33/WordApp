package com.saugatrai.wordapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.Executors

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private lateinit var INSTANCE: WordDatabase
        private val DB_NAME: String = "db_word"
        private const val NUMBER_OF_THREADS = 4
        var executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
        fun getInstance(context: Context): WordDatabase {
            if (INSTANCE == null) {
                synchronized(WordDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                WordDatabase::class.java, DB_NAME)
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}