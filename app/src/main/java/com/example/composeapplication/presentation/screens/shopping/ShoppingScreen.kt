package com.example.composeapplication.presentation.screens.shopping

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingScreen(

) {
        Text(text = "Shopping Screen", modifier = Modifier.padding(10.dp),
                color = MaterialTheme.colorScheme.onPrimary,)

}