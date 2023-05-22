package com.example.pruebacontiempo.ui.game

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pruebacontiempo.R
import com.example.pruebacontiempo.databinding.FragmentNewGameBinding

class NewGameFragment : Fragment() {

    private lateinit var binding: FragmentNewGameBinding

    private val viewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }


    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner){status->
            when {
                status.equals(GameViewModel.GAME_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getGames().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()
                    findNavController().popBackStack()
                }
                status.equals(GameViewModel.WRONG_DATA) -> {
                    Log.d("APP_TAG", status)
                        viewModel.clearStatus()
                }
            }
        }
    }

}