package com.example.pruebacontiempo.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pruebacontiempo.R
import com.example.pruebacontiempo.databinding.FragmentGameBinding
import com.example.pruebacontiempo.ui.game.viewmodel.GameViewModel

class GameFragment : Fragment() {


    private lateinit var binding: FragmentGameBinding

    private val gameViewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = gameViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}