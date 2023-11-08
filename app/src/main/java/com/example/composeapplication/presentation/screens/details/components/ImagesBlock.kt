package com.example.composeapplication.presentation.screens.details.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.presentation.screens.details.DetailsViewModel
import com.example.composeapplication.presentation.util.PicassoImage
import kotlinx.coroutines.delay

private const val PAGE_SIZE = 4

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesBlock(
    viewModel: DetailsViewModel,
    url: String,
    modifier: Modifier


) {

    val pagerState = rememberPagerState()
    var loader = viewModel.isLoaded
    var currentProgress by remember { mutableStateOf(0f) }

    LaunchedEffect(pagerState.currentPage) {
        viewModel.imageLoaded(true)
        for (i in 1..100) {
            currentProgress = (i.toFloat() / 100)
            delay(50)
        }

        viewModel.imageLoaded(false)
        var newPos = pagerState.currentPage + 1
        if (newPos >= PAGE_SIZE) {
            newPos = 0
        }
        pagerState.scrollToPage(newPos)
    }

    Box(
        modifier = modifier.fillMaxWidth()

    ) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {

            HorizontalPager(
                pageCount = PAGE_SIZE,
                state = pagerState,
                pageSize = PageSize.Fill,


                ) {

                PicassoImage(
                    url = url,
                    modifier = modifier
                )

            }
        }

        Box(
            modifier = modifier

                .offset(y = (-10).dp, x = (-10).dp)
                .clip(RoundedCornerShape(60))
                .background(MaterialTheme.colorScheme.onPrimary)
                //.padding(8.dp)
                .requiredHeight(36.dp)
                .align(Alignment.BottomEnd)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,

                modifier = modifier.padding(6.dp, 8.dp, 6.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                if (loader) {

                    CircularProgressIndicator(
                        modifier = Modifier
                            .requiredWidth(16.dp)
                            .requiredHeight(16.dp),
                        strokeWidth = 2.dp,
                        progress = currentProgress

                    )
                }

                Spacer(modifier = modifier.width(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.padding(end = 4.dp)
                ) {


                    Text(
                        text = "${pagerState.currentPage + 1}",
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 20.sp,
                    )

                    Text(
                        text = "/",
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 20.sp,
                    )

                    Text(
                        text = PAGE_SIZE.toString(),
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 20.sp,
                    )
                }
            }
        }
    }
}