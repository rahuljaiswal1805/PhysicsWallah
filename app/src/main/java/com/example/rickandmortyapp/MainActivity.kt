package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.navigation.NavGraph
import com.example.rickandmortyapp.network.RetrofitInstance
import com.example.rickandmortyapp.repository.CharacterRepository
import com.example.rickandmortyapp.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    val navController = rememberNavController()
                    val viewModel = CharacterViewModel(CharacterRepository(RetrofitInstance.api))
                    NavGraph(navController, viewModel)
        }
    }
}


