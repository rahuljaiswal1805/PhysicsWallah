package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortyapp.screens.CharacterDetailScreen
import com.example.rickandmortyapp.screens.CharacterListScreen
import com.example.rickandmortyapp.viewmodel.CharacterViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: CharacterViewModel) {
    NavHost(navController = navController, startDestination = "character_list") {
        composable("character_list") {
            CharacterListScreen(viewModel, navController)
        }
        composable("character/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: 0
            CharacterDetailScreen(viewModel, characterId)
        }
    }
}
