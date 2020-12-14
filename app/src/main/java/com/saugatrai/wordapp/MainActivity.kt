package com.saugatrai.wordapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: WordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionButton = findViewById<FloatingActionButton?>(R.id.fab)
        actionButton.setOnClickListener {
            val intent = Intent(this@MainActivity,
                    NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
        val wordList = findViewById<RecyclerView?>(R.id.word_list)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        wordList.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        wordList.addItemDecoration(itemDecoration)
        val adapter = WordAdapter()
        adapter.setWords(ArrayList())
        wordList.adapter = adapter
        val factory = ViewModelFactory(this)
        viewModel = ViewModelProvider(this, factory)
                .get(WordViewModel::class.java)
        viewModel.getAllWords().observe(this, { words -> adapter.setWords(words) })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            val word = data!!.getStringExtra(NewWordActivity.Companion.KEY_WORD)
            val newWord = Word(word)
            viewModel.insertWord(newWord)
        }
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Word not saved.", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }
}