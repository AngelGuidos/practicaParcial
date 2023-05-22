package com.example.pruebacontiempo.ui.game.billboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebacontiempo.R
import com.example.pruebacontiempo.data.model.GameModel
import com.example.pruebacontiempo.databinding.FragmentBillboardBinding
import com.example.pruebacontiempo.ui.game.billboard.recyclerview.GameRecyclerViewAdapter
import com.example.pruebacontiempo.ui.game.viewmodel.GameViewModel

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: GameRecyclerViewAdapter

    private val gameViewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener{
            gameViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newGameFragment)
        }
    }

    private fun showSelectedItem(game: GameModel) {
        gameViewModel.setSelected(game)
        Log.d("APP_TAG", game.name)
        findNavController().navigate(R.id.action_billboardFragment_to_gameFragment)
    }

    private fun displayGames() {
        adapter.setData(gameViewModel.getGames())
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerView(view: View){
        binding.recycler.layoutManager = LinearLayoutManager(view.context)

        adapter = GameRecyclerViewAdapter { selectedGame->
            showSelectedItem(selectedGame)
        }

        binding.recycler.adapter = adapter
        displayGames()
    }

}