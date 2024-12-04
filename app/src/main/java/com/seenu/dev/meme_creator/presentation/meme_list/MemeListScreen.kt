package com.seenu.dev.meme_creator.presentation.meme_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.seenu.dev.meme_creator.R
import com.seenu.dev.meme_creator.presentation.meme_list.components.EmptyMemeErrorView
import com.seenu.dev.meme_creator.presentation.meme_list.components.MemeTemplatesBottomSheet
import com.seenu.dev.meme_creator.presentation.utils.Route
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemeListScreen(navController: NavController, viewModel: MemeListViewModel = hiltViewModel()) {

    val memes by viewModel.memesList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getMemes()
    }

    var showTemplatesBottomSheet by remember {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.your_memes_title))
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            showTemplatesBottomSheet = true
        }, shape = MaterialTheme.shapes.medium) {
            Icon(painter = painterResource(R.drawable.meme_add), contentDescription = "Add meme")
        }
    }) { paddingValues ->

        if (memes.isEmpty()) {
            EmptyMemeErrorView(modifier = Modifier.fillMaxSize())
        } else {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                columns = GridCells.Fixed(2)
            ) {
                items(100) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1F)
                            .background(
                                Color(
                                    (0..255).random(),
                                    (0..255).random(),
                                    (0..255).random()
                                )
                            )
                            .clip(MaterialTheme.shapes.small)
                    )
                }
            }
        }
    }

    if (showTemplatesBottomSheet) {
        MemeTemplatesBottomSheet(sheetState = sheetState, onClick = { id ->
            scope.launch {
                sheetState.hide()
            }
            navController.navigate("${Route.MemeEdit}/$id")
        }) {
            showTemplatesBottomSheet = false
        }
    }

}