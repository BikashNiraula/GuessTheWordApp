package com.example.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.guesstheword.R
import com.example.guesstheword.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var viewModal: GameViewModal


    // The list of words - the front of the list is the next word to guess
//    private lateinit var wordList: MutableList<String>

    private lateinit var binding: FragmentGameBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )
        Log.i("GameViewModal", "ViewModal Provider Called")
        viewModal = ViewModelProvider(this).get(GameViewModal::class.java)



        binding.correctButton.setOnClickListener { viewModal.onCorrect()
            updateScoreText()
            updateWordText()
        }
        binding.skipButton.setOnClickListener { viewModal.onSkip()
            updateScoreText()
            updateWordText()
        }
        updateScoreText()
        updateWordText()
        return binding.root
    }




    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        val action = GameFragmentDirections.actionGameToScore(viewModal.score)
        findNavController().navigate(action)
    }

    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = viewModal.word

    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModal.score.toString()
    }
}