package com.seenu.dev.meme_creator.presentation.meme_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.seenu.dev.meme_creator.R
import com.seenu.dev.meme_creator.presentation.utils.MEME_TEMPLATES_ID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemeTemplatesBottomSheet(
    sheetState: SheetState,
    onClick: (id: Int) -> Unit,
    onDismiss: () -> Unit
) {
    val templates = MEME_TEMPLATES_ID
    ModalBottomSheet(sheetState = sheetState, onDismissRequest = onDismiss) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp)) {
            Text(
                text = stringResource(R.string.choose_template_title),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
            Text(
                text = stringResource(R.string.choose_template_msg),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
            LazyVerticalGrid(modifier = Modifier.padding(8.dp), columns = GridCells.Fixed(2)) {
                items(templates) { res ->
                    MemePreviewCard(
                        painter = painterResource(res),
                        contentScale = ContentScale.FillHeight,
                        showSelectOption = false,
                        showLikeIcon = false,
                        modifier = Modifier
                            .aspectRatio(1F)
                            .padding(
                                8.dp
                            )
                            .clip(MaterialTheme.shapes.small)
                            .clickable {
                                onClick(res)
                            }
                    )
                }
            }
        }
    }
}