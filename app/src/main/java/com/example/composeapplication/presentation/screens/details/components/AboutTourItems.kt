package com.example.composeapplication.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
fun AboutTourItems(
    modifier: Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp).background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(5.dp)
            ),

    ) {

        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Row(
                verticalAlignment = Alignment.Top,

                ) {
                Image(
                    painter = painterResource(id = R.drawable.clock_check),
                    contentDescription = "clock",
                    modifier = modifier
                        .requiredHeight(24.dp)
                        .requiredWidth(24.dp)
                )

                Column(
                    modifier = modifier.padding(start = 8.dp),
                    verticalArrangement = Arrangement.Top
                ) {

                    Text(
                        text = "Продолжительность",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp,


                        )

                    Text(text = "от 5 до 8 дней",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp
                    )
                }
            }

        }

        Divider(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 36.dp, top = 16.dp, bottom = 16.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.departure_icon),
                    contentDescription = "departure",
                    modifier = modifier
                        .requiredHeight(24.dp)
                        .requiredWidth(24.dp)
                )

                Column(
                    modifier = modifier.padding(start = 8.dp),
                    verticalArrangement = Arrangement.Top,
                ) {


                    Text(
                        text = "Отправление",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp
                    )

                    Text(text = "Из Хабаровска",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp
                    )
                }
            }
        }

        Divider(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 36.dp, top = 16.dp, bottom = 16.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.included_ic),
                    contentDescription = "included",
                    modifier = modifier
                        .requiredHeight(24.dp)
                        .requiredWidth(24.dp)
                )

                Column(
                    modifier = modifier.padding(start = 8.dp)
                ) {


                    Text(
                        text = "Включено",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp

                    )

                    Text(text = "Проживание в домике, 3-х разовое питание, проезд на автобусе",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp
                    )
                }
            }
        }

        Divider(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 36.dp, top = 16.dp, bottom = 16.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.not_included_ic),
                    contentDescription = "included",
                    modifier = Modifier
                        .requiredHeight(24.dp)
                        .requiredWidth(24.dp)
                )

                Column(
                    modifier = modifier.padding(start = 8.dp)
                ) {


                    Text(
                        text = "Не включено",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 21.sp,
                        letterSpacing = (-0.32).sp
                        )

                    Text(text = "Личные расходы, постельное белье",
                        color = MaterialTheme.colorScheme.onPrimary,
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
}