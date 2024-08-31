package com.example.rickandmortyapp.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.models.Character
import com.example.rickandmortyapp.models.CharacterResponse
import com.example.rickandmortyapp.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val repository = CharacterRepository()

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> get() = _characters

    private val _selectedCharacter = MutableStateFlow<Character?>(null)
    val selectedCharacter: StateFlow<Character?> get() = _selectedCharacter

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response: CharacterResponse = repository.getCharacters()
                _characters.value = response.results
            } catch (e: Exception) {
                Log.d("Rahul", "Error in characters API")
            }
        }
    }

    fun selectCharacter(id: Int) {
        viewModelScope.launch {
            try {
                _selectedCharacter.value = repository.getCharacterDetails(id)
            } catch (e: Exception) {
                Log.d("Rahul", "Error in details API")
            }
        }
    }
}
