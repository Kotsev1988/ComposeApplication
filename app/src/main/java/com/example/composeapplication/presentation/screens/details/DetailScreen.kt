package com.example.composeapplication.presentation.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapplication.presentation.util.ErrorScreen
import com.example.composeapplication.presentation.util.LoadingScreen
import com.example.composeapplication.presentation.screens.details.components.AboutTourItems
import com.example.composeapplication.presentation.screens.details.components.CheckInBlock
import com.example.composeapplication.presentation.screens.details.components.Description
import com.example.composeapplication.presentation.screens.details.components.DetailScreenDevider
import com.example.composeapplication.presentation.screens.details.components.ImagesBlock
import com.example.composeapplication.presentation.screens.details.components.ListOfContacts
import com.example.composeapplication.presentation.screens.details.components.Title


@Composable
fun DetailScreen(
    id: Int
) {
    val viewModel: DetailsViewModel = hiltViewModel()
    val contentState = viewModel.detailState
    val context = LocalContext.current.applicationContext


    Surface(
        color = MaterialTheme.colorScheme.background
    ) {

        when (contentState) {
            is DetailAppState.OnSuccessContents -> {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {

                    ImagesBlock(viewModel, contentState.imageUrl, Modifier)

                    Title(context, modifier = Modifier, text = contentState.title)

                    DetailScreenDevider(modifier = Modifier)

                    AboutTourItems(modifier = Modifier)

                    DetailScreenDevider(modifier = Modifier)

                    Description(modifier = Modifier, description = contentState.content)

                    DetailScreenDevider(modifier = Modifier)

                    ListOfContacts(modifier = Modifier)

                    DetailScreenDevider(modifier = Modifier)

                    CheckInBlock(Modifier)

                }
            }

            is DetailAppState.Error -> {
                ErrorScreen(contentState.error)
            }

            is DetailAppState.Loading -> {
                LoadingScreen(isLoading = true)
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
    val price: String

)


