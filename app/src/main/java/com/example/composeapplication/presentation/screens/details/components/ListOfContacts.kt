package com.example.composeapplication.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R

@Composable
fun ListOfContacts(
    modifier: Modifier,
) {
    val listOfContacts = listOf<ListOfContact>(
        ListOfContact("ООО РСТ-TУР", "Компания", ""),
        ListOfContact("ООО РСТ-ЕУР", "Компания", ""),
        ListOfContact("ООО РСТ-ЕУР", "Компания", ""),
    )
    Column(
        modifier = modifier.padding(16.dp)
    ) {

        Text(
            text = "Контакты",
            style = TextStyle(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 34.sp,
                fontWeight = FontWeight(400),
                lineHeight = 36.sp
            )
        )

        LazyRow {
            itemsIndexed(listOfContacts) { index, item ->

                Card(
                    modifier = modifier
                        .requiredHeight(168.dp)
                        .requiredWidth(300.dp)
                        .padding(start = 2.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.onBackground
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Column(
                        modifier = modifier
                            .padding(16.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {


                        Row() {
                            Image(
                                painter = painterResource(id = R.drawable.avatar),
                                contentDescription = "included",
                                modifier = modifier
                                    .requiredHeight(40.dp)
                                    .requiredWidth(40.dp)
                            )

                            Column(
                                modifier = modifier.padding(start = 8.dp)
                            ) {

                                Text(
                                    text = item.name,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Start,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 22.sp,
                                    letterSpacing = (-0.32).sp
                                )

                                Text(
                                    text = item.userType,
                                    color = Color(0xFF808080),
                                    textAlign = TextAlign.Start,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    lineHeight = 24.sp,
                                    letterSpacing = (-0.32).sp
                                )
                            }
                        }

                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            //verticalAlignment = Alignment.Bottom

                        ) {

                            Button(
                                onClick = {},
                                modifier = modifier.requiredWidth(120.dp),
                                contentPadding = PaddingValues(10.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFFE6F1FE))
                            ) {
                                Text(
                                    text = "Написать",
                                    style = TextStyle(
                                        color = Color(0xFF4096FB),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(700),
                                    ),
                                )
                            }

                            Button(
                                onClick = {},
                                modifier = modifier.requiredWidth(120.dp),
                                contentPadding = PaddingValues(10.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFFE6F1FE))
                            ) {
                                Text(

                                    style = TextStyle(
                                        color = Color(0xFF4096FB),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(700),

                                        ),
                                    text = "Позвонить",
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class ListOfContact(
    val name: String,
    val userType: String,
    val img: String
)