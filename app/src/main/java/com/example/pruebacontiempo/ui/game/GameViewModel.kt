package com.example.pruebacontiempo.ui.game

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pruebacontiempo.GameReviewerApplication
import com.example.pruebacontiempo.data.model.GameModel
import com.example.pruebacontiempo.repositories.GameRepository

class GameViewModel (private val repository: GameRepository): ViewModel() {
    var name = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    val status = MutableLiveData("")

    fun getGames() = repository.getGames()

    fun addGame(game: GameModel) = repository.addGame(game)

    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun clearData() {
        name.value = ""
        description.value = ""
        qualification.value = ""
    }

    fun createGame(){
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }
        val game = GameModel(
            name.value!!,
            description.value!!,
            qualification.value!!
        )
        addGame(game)
        clearData()

        status.value = GAME_CREATED
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as GameReviewerApplication
                GameViewModel(app.gameRepository)
            }
        }
        const val GAME_CREATED = "Game created"
        const val WRONG_DATA = "Wrong data "
        const val INACTIVE = ""
    }
}