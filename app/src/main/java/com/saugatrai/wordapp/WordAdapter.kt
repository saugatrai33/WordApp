package com.saugatrai.wordapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saugatrai.wordapp.WordAdapter.WordViewHolder

class WordAdapter : RecyclerView.Adapter<WordViewHolder>() {
    private lateinit var words: MutableList<Word>
    fun setWords(words: MutableList<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words.get(position)
        holder.wordText.setText(word.getWord())
    }

    override fun getItemCount(): Int {
        return words.size
    }

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var wordText: TextView

        init {
            wordText = itemView.findViewById(R.id.word)
        }
    }
}