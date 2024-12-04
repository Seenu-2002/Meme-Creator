package com.seenu.dev.meme_creator.presentation.meme_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.seenu.dev.meme_creator.R
import com.seenu.dev.meme_creator.domain.model.Meme

@Composable
fun MemePreviewCard(
    painter: Painter,
    contentScale: ContentScale = ContentScale.Fit,
    isLiked: Boolean = false,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
    showLikeIcon: Boolean = true,
    showSelectOption: Boolean = false,
    onLikeClicked: (() -> Unit)? = null,
    onSelectClicked: (() -> Unit)? = null,
) {
    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = "Meme image",
            contentScale = contentScale,
            modifier = Modifier.matchParentSize()
        )
        ConstraintLayout(modifier = Modifier.matchParentSize()) {
            val (checkbox, likeBtn) = createRefs()

            if (showSelectOption) {
                IconToggleButton(modifier = Modifier
                    // TODO: Shadow
//                    .background(brush = Brush.linearGradient(
//                        colors = listOf(Color.Transparent, Color.Black),
//                        start = Offset(0F, Float.POSITIVE_INFINITY),
//                        end = Offset(Float.POSITIVE_INFINITY, 0F)
//                    ))
                    .constrainAs(checkbox) {
                    linkTo(parent.top, parent.bottom, bias = 0F)
                    linkTo(parent.start, parent.end, bias = 1F)
                }, checked = false, onCheckedChange = {
                    onSelectClicked?.invoke()
                }) {
                    val likeImagePainter = if (isSelected) {
                        painterResource(R.drawable.meme_selected_filled)
                    } else {
                        painterResource(R.drawable.meme_selected_unfilled)
                    }
                    Icon(painter = likeImagePainter, contentDescription = "Like Button")
                }
            }

            if (showLikeIcon) {
                IconToggleButton(modifier = Modifier.constrainAs(likeBtn) {
                    linkTo(parent.top, parent.bottom, bias = 1F)
                    linkTo(parent.start, parent.end, bias = 1F)
                }, checked = false, onCheckedChange = {
                    onLikeClicked?.invoke()
                }) {
                    val likeImagePainter = if (isLiked) {
                        painterResource(R.drawable.meme_like_filled)
                    } else {
                        painterResource(R.drawable.meme_like_unfilled)
                    }
                    Icon(painter = likeImagePainter, contentDescription = "Like Button")
                }
            }
        }
    }
}

@Preview
@Composable
private fun MemePreviewCardPreviewWithLike() {
    val meme = Meme(
        1110L,
        "Meme 1",
        false,
        ""
    )

    var isLiked by remember {
        mutableStateOf(true)
    }

    MemePreviewCard(
        painter = painterResource(R.drawable.boardroom_meeting_suggestion_36),
        contentScale = ContentScale.FillBounds,
        isSelected = false,
        isLiked = isLiked,
        showSelectOption = false,
        showLikeIcon = true,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.small
            )
            .clip(MaterialTheme.shapes.small)
            .size(100.dp),
        onLikeClicked = {
            isLiked = !isLiked
        }
    )
}

@Preview
@Composable
private fun MemePreviewCardPreviewWithSelect() {
    val meme = Meme(
        1110L,
        "Meme 1",
        false,
        ""
    )

    var isSelected by remember {
        mutableStateOf(true)
    }
    MemePreviewCard(
        painter = painterResource(R.drawable.eyvu_45),
        contentScale = ContentScale.FillHeight,
        isSelected = isSelected,
        isLiked = false,
        showSelectOption = true,
        showLikeIcon = false,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.small
            )
            .clip(MaterialTheme.shapes.small)
            .size(100.dp),
        onSelectClicked = {
            isSelected = !isSelected
        }
    )
}