package com.example.composeapplication.presentation.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(

) {
        Text(text = "Search Screen", modifier = Modifier.padding(10.dp),
                color = MaterialTheme.colorScheme.onPrimary,)

}