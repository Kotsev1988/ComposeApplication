package com.example.composeapplication.presentation.screens.details.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R

@Composable
fun Title(
    context: Context,
    modifier: Modifier,
    text: String
    ){
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Column {
            Text(text = text,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Start,
                fontSize = 34.sp,
                fontWeight = FontWeight(400),
                lineHeight = 41.sp,
                letterSpacing = 0.37.sp

            )

            Row(
                modifier = modifier.padding(top = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.star_outline), contentDescription ="star" ,
                    modifier = Modifier
                        .requiredHeight(19.dp)
                        .requiredWidth(20.dp))
                Text(text = "Нет отзывов",

                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 22.sp,
                    letterSpacing = (-0.32).sp

                )
            }
            TextButton(onClick = { Toast.makeText(context, "Открыть карту", Toast.LENGTH_SHORT).show()},
                contentPadding = PaddingValues(1.dp),
                modifier = Modifier.defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = 16.dp
                )
            ){
                Text(text = "Россия, Приморский край, Находка",
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
}