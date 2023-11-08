package com.example.composeapplication.presentation.screens.details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R
import com.example.composeapplication.presentation.screens.details.CheckIn
import kotlinx.coroutines.launch

@Composable
fun CheckInBlock(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(

        ) {
            Text(
                text = "Выберите заезд",
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Start,
                fontSize = 32.sp,
                fontWeight = FontWeight(600),
                lineHeight = 36.sp
            )
        }

        Column() {

            TextButton(onClick = {}) {
                Text(
                    text = "Все(20)",
                    color = Color(0xFF4299FF),
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 24.sp
                )
            }
        }
    }


    val listOfCheckIn = listOf(
        CheckIn(
            timeFrom = "12.07.2021",
            timeEnd = "17.07.2021",
            countOfNights = "3",
            discount = "15%",
            childDiscount = "100%",
            price = "11 070"
        ),
        CheckIn(
            timeFrom = "13.07.2021",
            timeEnd = "29.07.2021",
            countOfNights = "7",
            discount = "35%",
            childDiscount = "1000%",
            price = "13 320"
        ),
        CheckIn(
            timeFrom = "30.07.2021",
            timeEnd = "31.07.2021",
            countOfNights = "1",
            discount = "25%",
            childDiscount = "90%",
            price = "14 590"
        )
    )

    var listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        var selectedOption by remember {
            mutableStateOf("")
        }

        var selectedIndex by remember {
            mutableStateOf(0)
        }
        var onSelectionChange = { text: String ->
            selectedOption = text
        }

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Прибрежная 6 дней",
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                fontWeight = FontWeight(600),
                lineHeight = 28.sp,
                letterSpacing = (-0.35).sp
            )

            TextButton(onClick = {}) {
                Text(
                    text = "Все(20)",
                    color = Color(0xFF4299FF),
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 24.sp
                )
            }
        }

        LazyRow() {

            item {
                OutlinedButton(
                    onClick = {

                        onSelectionChange("Июль")
                        selectedIndex = 0
                        coroutineScope.launch {
                            listState.animateScrollToItem(selectedIndex)
                        }
                    },
                    modifier = modifier.padding(0.dp, 16.dp, 8.dp, 16.dp),
                    border = BorderStroke(0.dp, Color.Transparent),

                    colors = if (selectedOption == "Июль") ButtonDefaults.buttonColors(

                        containerColor = Color(0xFF4096FB),
                        contentColor = Color(0xFFFFFFFF)

                    ) else ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE6F1FE),
                        contentColor = Color(0xFF0A78FA)
                    )
                ) {
                    Text(
                        text = "Июль ",
                        modifier = modifier.padding(end = 6.dp)
                    )
                }
            }

            item {
                OutlinedButton(
                    onClick = {
                        onSelectionChange("Август")
                        selectedIndex = 1
                        coroutineScope.launch {
                            listState.animateScrollToItem(selectedIndex)
                        }
                    },
                    modifier = modifier.padding(8.dp, 16.dp, 8.dp, 16.dp),

                    border = BorderStroke(0.dp, Color.Transparent),

                    colors = if (selectedOption == "Август") ButtonDefaults.buttonColors(

                        containerColor = Color(0xFF4096FB),
                        contentColor = Color(0xFFFFFFFF)

                    ) else ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE6F1FE),
                        contentColor = Color(0xFF0A78FA)
                    )
                ) {
                    Text(text = "Авгуcт", modifier = modifier.padding(start = 3.dp))

                    Text(
                        text = "5",

                        modifier
                            .border(
                                BorderStroke(1.dp, Color(0xFFB3D5FD)), CircleShape
                            )
                            .safeContentPadding()
                            .padding(
                                top = 3.dp,
                                bottom = 3.dp,
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                }
            }

            item {
                OutlinedButton(
                    onClick = {
                        onSelectionChange("Сентябрь")
                        selectedIndex = 2
                        coroutineScope.launch {
                            listState.animateScrollToItem(selectedIndex)
                        }

                    },
                    modifier = modifier.padding(8.dp, 16.dp, 8.dp, 16.dp),
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = if (selectedOption == "Сентябрь") ButtonDefaults.buttonColors(

                        containerColor = Color(0xFF4096FB),
                        contentColor = Color(0xFFFFFFFF)

                    ) else ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE6F1FE),
                        contentColor = Color(0xFF0A78FA)
                    )
                ) {
                    Text(text = "Сентябрь", modifier = modifier.padding(start = 3.dp))

                    Text(
                        text = "1",
                        modifier
                            .border(
                                BorderStroke(1.dp, Color(0xFFB3D5FD)), CircleShape
                            )
                            .safeContentPadding()
                            .padding(
                                top = 3.dp,
                                bottom = 3.dp,
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                }
            }

        }

        LazyRow(
            state = listState,
            modifier = modifier.fillMaxWidth()
        ) {
            itemsIndexed(listOfCheckIn) { index, item ->

                Card(
                    modifier = modifier
                        .requiredWidth(300.dp)
                        .fillMaxHeight().padding(start= 0 .dp, end = 10.dp, top =10.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.onBackground
                    )
                ) {

                    Column(
                        modifier = modifier
                            .fillMaxHeight().fillMaxWidth().padding(4.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(modifier = modifier.padding(start = 0.dp)) {

                            Row(
                                verticalAlignment = Alignment.Top,

                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.time_from_ic),
                                    contentDescription = "time_from",
                                    modifier = modifier
                                        .requiredHeight(24.dp)
                                        .requiredWidth(24.dp)
                                )

                                Column(
                                    modifier = modifier.padding(start = 10.dp),
                                    verticalArrangement = Arrangement.Top,
                                ) {
                                    Text(
                                        text = item.timeFrom,
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        textAlign = TextAlign.Start,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(600),
                                        lineHeight = 21.sp,
                                        letterSpacing = (-0.32).sp,
                                    )
                                }
                            }

                            Row(
                                verticalAlignment = Alignment.Top,

                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.time_end_ic),
                                    contentDescription = "clock",
                                    modifier = modifier
                                        .requiredHeight(24.dp)
                                        .requiredWidth(24.dp)
                                )

                                Column(
                                    modifier = modifier.padding(start = 8.dp),
                                    verticalArrangement = Arrangement.Top,
                                ) {

                                    Text(
                                        text = item.timeEnd,
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
                                .padding(start = 36.dp, top = 16.dp, bottom = 16.dp)
                        )


                        Row() {
                            Image(
                                painter = painterResource(id = R.drawable.count_night_ic),
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
                                    text = item.countOfNights + " ночи",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Start,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 21.sp,
                                    letterSpacing = (-0.32).sp
                                )
                            }
                        }


                        Divider(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(start = 36.dp, top = 16.dp, bottom = 16.dp)
                        )

                        Row() {
                            Column(
                                modifier = modifier.padding(start = 8.dp)
                            ) {

                                Text(
                                    text = item.discount,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Start,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 21.sp,
                                    letterSpacing = (-0.32).sp
                                )

                                Text(
                                    text = item.childDiscount,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Start,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 21.sp,
                                    letterSpacing = (-0.32).sp
                                )
                            }

                            Column(modifier = modifier.padding(start = 8.dp)) {

                                Text(
                                    text = "На два туриста",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Start,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 21.sp,
                                    letterSpacing = (-0.32).sp
                                )

                                Text(
                                    text = "До 3 лет",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Start,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    lineHeight = 21.sp,
                                    letterSpacing = (-0.32).sp
                                )
                            }
                        }
                    }

                    Divider(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 36.dp, bottom = 16.dp)
                    )

                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom =16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(

                        ) {
                            Text(
                                text = item.price,
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp,
                                fontWeight = FontWeight(700),
                                lineHeight = 28.8.sp
                            )

                            Text(
                                text = "за человека",
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 16.sp
                            )
                        }

                        Column(

                        ) {

                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(10.dp),
                                colors = androidx.compose.material.ButtonDefaults.buttonColors(
                                    Color(
                                        0xFF4096FB
                                    )
                                )
                            ) {
                                Text(
                                    text = "Выбрать",
                                    style = TextStyle(
                                        color = Color(0xFFFFFFFF),
                                        textAlign = TextAlign.Center,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(500),
                                        lineHeight = 24.sp
                                    ),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class CheckIn(
    val timeFrom: String,
    val timeEnd: String,
    val countOfNights: String,
    val discount: String,
    val childDiscount: String,
    val price: String,

    )