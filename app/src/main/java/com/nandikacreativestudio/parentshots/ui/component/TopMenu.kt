package com.nandikacreativestudio.parentshots.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularMenuButton(
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = colorScheme.surfaceVariant)
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            tint = colorScheme.onSurface
        )
    }
}

@Composable
fun CircularSearchButton(
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = colorScheme.surfaceVariant)
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = colorScheme.onSurface
        )
    }
}

@Composable
fun CircularFavoriteButton(
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = colorScheme.surfaceVariant)
    ) {
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Favorite",
            tint = colorScheme.onSurface
        )
    }
}

@Composable
fun CircularBackButton(
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = colorScheme.surfaceVariant)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = "Back",
            tint = colorScheme.onSurface
        )
    }
}

@Composable
fun CircularShareButton(
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = colorScheme.surfaceVariant)
    ) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "Share",
            tint = colorScheme.onSurface
        )
    }
}

@Composable
fun CircularPlayButton(
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = Color.Red)
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Share",
            tint = Color.White
        )
    }
}