package com.example.pruebacontiempo.ui.game.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.pruebacontiempo.data.model.GameModel
import com.example.pruebacontiempo.databinding.FragmentNewGameBinding
import com.example.pruebacontiempo.databinding.GameItemBinding
//import com.example.pruebacontiempo.generated.callback.OnClickListener

class GameRecyclerViewHolder(private val binding: GameItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(game: GameModel, clickListener: (GameModel)-> Unit){
        binding.nameItem.text = game.name
        binding.descItem.text = game.description
        binding.quaItem.text = game.qualification

        binding.itemCard.setOnClickListener{
            clickListener(game)
        }
    }
}