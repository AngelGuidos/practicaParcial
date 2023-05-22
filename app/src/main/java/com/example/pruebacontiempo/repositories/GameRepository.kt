package com.example.pruebacontiempo.repositories

import com.example.pruebacontiempo.data.model.GameModel

class GameRepository(private val games: MutableList<GameModel>) {

    fun getGames() = games

    fun addGame(newGame: GameModel) = games.add(newGame)
}