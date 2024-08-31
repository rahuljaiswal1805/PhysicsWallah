package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.models.Character
import com.example.rickandmortyapp.models.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Character
}
