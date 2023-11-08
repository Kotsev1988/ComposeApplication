package com.example.composeapplication.presentation.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.example.composeapplication.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

@Composable
fun PicassoImage(
    url: String,
    modifier: Modifier
){

    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    var drawable by remember { mutableStateOf<Drawable?>(null) }

    val picasso = Picasso.get()


    val target = object : Target {
        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {

            image = bitmap?.asImageBitmap()
        }

        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
            drawable = errorDrawable
        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            drawable = placeHolderDrawable
        }
    }


    LaunchedEffect(key1 = image){

        picasso
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.baseline_error_24)
            .into(target)
    }



    image?.let {
        Image(
        bitmap = it,
        contentDescription = "picasso image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth())
    }
}