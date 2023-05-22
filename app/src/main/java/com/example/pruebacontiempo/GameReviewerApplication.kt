package com.example.pruebacontiempo

import android.app.Application
import com.example.pruebacontiempo.data.games
import com.example.pruebacontiempo.repositories.GameRepository

class GameReviewerApplication: Application() {
    val gameRepository: GameRepository by lazy {
        GameRepository(games)
    }
}