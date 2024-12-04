package com.seenu.dev.meme_creator.presentation.meme_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seenu.dev.meme_creator.R

@Preview
@Composable
fun EmptyMemeErrorView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.memes_empty_icon),
            contentDescription = "Empty Meme Error Icon",
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = stringResource(R.string.create_meme_msg),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier.padding(12.dp)
        )
    }
}