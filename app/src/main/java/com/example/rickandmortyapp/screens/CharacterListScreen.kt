package com.example.rickandmortyapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.rickandmortyapp.viewmodel.CharacterViewModel

@Composable
fun CharacterListScreen(viewModel: CharacterViewModel, navController: NavController) {
    Column() {
        Text(
            text = "Rick and Morty",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineMedium
        )

        CharacterList(viewModel = viewModel, navController = navController)
    }
}



@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {

}
