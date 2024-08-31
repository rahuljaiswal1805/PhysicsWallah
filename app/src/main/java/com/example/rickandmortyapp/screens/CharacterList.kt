package com.example.rickandmortyapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.rickandmortyapp.viewmodel.CharacterViewModel

@Composable
fun CharacterList(viewModel: CharacterViewModel, navController: NavController) {
    val characters by viewModel.characters.collectAsState()
    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character) {
                navController.navigate("character/${character.id}")
            }
        }
    }
}