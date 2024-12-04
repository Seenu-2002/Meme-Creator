package com.seenu.dev.meme_creator.presentation.meme_editor

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.seenu.dev.meme_creator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemeEditorScreen(navController: NavController, @DrawableRes drawableRes: Int) {

    var isTextFocused by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(text = stringResource(R.string.new_meme_title))
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Image(
                painter = painterResource(drawableRes),
                contentDescription = "Editable meme image",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            )

            if (!isTextFocused) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(modifier = Modifier.padding(vertical = 8.dp), onClick = {

                    }) {
                        Text(stringResource(R.string.add_text_button_text))
                    }
                    Button(modifier = Modifier.padding(8.dp), onClick = {

                    }) {
                        Text(stringResource(R.string.save_meme_button_text))
                    }
                }
            } else {

            }
        }
    }

}