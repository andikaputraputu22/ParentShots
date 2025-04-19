package com.nandikacreativestudio.parentshots.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nandikacreativestudio.parentshots.ui.component.CircularFavoriteButton
import com.nandikacreativestudio.parentshots.ui.component.CircularMenuButton
import com.nandikacreativestudio.parentshots.ui.component.CircularSearchButton

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopMenuNavigation(
            onMenuClick = {},
            onSearchClick = {},
            onFavoriteClick = {}
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Home Screen",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Composable
fun TopMenuNavigation(
    onMenuClick: () -> Unit,
    onSearchClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircularMenuButton(
            onClick = onMenuClick
        )
        Row {
            CircularSearchButton(
                onClick = onSearchClick
            )
            Spacer(modifier = Modifier.width(8.dp))
            CircularFavoriteButton(
                onClick = onFavoriteClick
            )
        }
    }
}