package com.example.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModal: ViewModel() {
    init {
        resetList()
        nextWord()
        Log.i("GameViewModal","GameViewModal created.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModal","GameViewModal destroyed")
    }
     var word = ""

    // The current score
     var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            //gameFinished()
        } else {
            word = wordList.removeAt(0)
        }

    }
     fun onSkip() {
        score--
        nextWord()
    }

     fun onCorrect() {
        score++
        nextWord()
    }
}