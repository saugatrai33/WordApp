package com.saugatrai.wordapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        val inputText = findViewById<EditText?>(R.id.word)
        val saveBtn = findViewById<Button?>(R.id.btnSave)
        saveBtn.setOnClickListener {
            val enterWord = inputText.text.toString().trim { it <= ' ' }
            val intent = Intent()
            if (!TextUtils.isEmpty(enterWord)) {
                intent.putExtra(KEY_WORD, enterWord)
                setResult(RESULT_OK, intent)
            } else {
                setResult(RESULT_CANCELED, intent)
            }
            finish()
        }
    }

    companion object {
        val KEY_WORD: String? = "WORD"
    }
}