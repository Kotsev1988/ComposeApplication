package com.example.composeapplication.presentation.screens.blogs

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composeapplication.presentation.util.ErrorScreen
import com.example.composeapplication.presentation.util.LoadingScreen

@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)

@Composable
fun BlogsScreen(
    navController: NavController
) {

    val viewModel: BlogsViewModel = hiltViewModel()

    val contentState = viewModel.blogsState

        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Column() {

            when (contentState) {
                is BlogsAppState.OnSuccessContents -> {

                    LazyVerticalGrid(
                        //columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        columns = GridCells.Adaptive(150.dp),
                        contentPadding = PaddingValues(4.dp),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        itemsIndexed(contentState.content) { _, item ->
                            Blogs(content = item, modifier = Modifier, navController)
                        }
                    }
                }

                is BlogsAppState.Loading -> {
                    LoadingScreen(isLoading = true)
                }

                is BlogsAppState.Error -> {
                    ErrorScreen(contentState.error)
                }
            }
        }
        }
}

