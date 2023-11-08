package com.example.composeapplication.presentation.screens.details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun Description(
    modifier: Modifier,
    description: String

){
    var showAllText by remember { mutableStateOf(false) }

    Text(text = "Описание",
        Modifier.padding(16.dp),
        color = MaterialTheme.colorScheme.onPrimary,
        textAlign = TextAlign.Start,
        fontSize = 34.sp,
        fontWeight = FontWeight(400),
        lineHeight = 36.sp,
    )


    if (showAllText) {
        MarkdownText(
            modifier = modifier.padding(16.dp),
            markdown = description,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium,
            linkColor =  MaterialTheme.colorScheme.onPrimary
        )
        TextButton(onClick = {showAllText = ! showAllText}){
            Text(text = stringResource(R.string.collapse),
                modifier = Modifier.padding(16.dp),
                color = Color(0xFF4299FF),
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 21.sp,
                letterSpacing = (-0.32).sp
            )
        }
    }else{
        MarkdownText(
            modifier = modifier.padding(16.dp),
            markdown = description,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            maxLines = 6,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium,
            linkColor =  MaterialTheme.colorScheme.onPrimary
        )

        TextButton(onClick = {showAllText = ! showAllText}){
            Text(text = stringResource(R.string.read_more),
                color = Color(0xFF4299FF),
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 21.sp,
                letterSpacing = (-0.32).sp
            )
        }
    }
}