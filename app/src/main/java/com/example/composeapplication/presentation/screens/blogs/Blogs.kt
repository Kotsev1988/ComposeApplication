package com.example.composeapplication.presentation.screens.blogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeapplication.domain.model.ContentData
import com.example.composeapplication.presentation.util.PicassoImage

@Composable
fun Blogs(
    content: ContentData,
    modifier: Modifier = Modifier,
    navigation: NavController,
    ) {

    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(166.dp)
            .clickable {
                navigation.navigate("DetailScreen/${content.id}")
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .requiredHeight(104.dp)

            ) {

                PicassoImage(content.contentImage.md, modifier)
            }

            Text(
                text = content.title,
                modifier = modifier.padding(start = 4.dp, end = 4.dp, top = 4.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                lineHeight = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = modifier.padding(1.dp))

            Text(
                text = content.subtitle,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.sp
                ),
                modifier = modifier.padding(start = 4.dp, end = 4.dp),
                textAlign = TextAlign.Start,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}