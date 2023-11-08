package com.example.composeapplication.presentation.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R

@Composable
fun ErrorScreen(
    errorText: String,
    modifier: Modifier = Modifier

) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

            Text(text = if  (errorText.isNullOrEmpty()) errorText else stringResource(R.string.error),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 21.sp,
                letterSpacing = (-0.32).sp,
                )

    }
}