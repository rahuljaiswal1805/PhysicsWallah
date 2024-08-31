package com.example.rickandmortyapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.example.rickandmortyapp.viewmodel.CharacterViewModel
import android.content.res.Configuration
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun CharacterDetailScreen(viewModel: CharacterViewModel, characterId: Int) {
    val character by viewModel.selectedCharacter.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.selectCharacter(characterId)
    }

    character?.let {

        val scrollState = rememberScrollState()

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(1f)
                .verticalScroll(scrollState)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier.padding(32.dp).width(300.dp)
            ) {

                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = rememberImagePainter(it.image),
                        contentDescription = null,
                        modifier = Modifier.height(300.dp).width(300.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Name: ${it.name}",
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(text = "Status: ${it.status}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Species: ${it.species}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Gender: ${it.gender}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun CharacterDetailPreview() {

}
