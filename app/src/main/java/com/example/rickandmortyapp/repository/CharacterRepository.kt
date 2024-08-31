package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.models.Character
import com.example.rickandmortyapp.models.CharacterResponse
import com.example.rickandmortyapp.network.RetrofitInstance


class CharacterRepository {
    private val api = RetrofitInstance.api

    suspend fun getCharacters(): CharacterResponse = api.getCharacters()

    suspend fun getCharacterDetails(id: Int): Character = api.getCharacterDetails(id)
}
