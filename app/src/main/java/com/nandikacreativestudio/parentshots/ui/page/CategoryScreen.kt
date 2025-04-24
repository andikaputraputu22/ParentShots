package com.nandikacreativestudio.parentshots.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryScreen() {
    val categories = listOf(
        "All News",
        "Parenting",
        "Children",
        "Pregnant",
        "Baby",
        "Kids",
        "Food"
    )
    var selectedCategory by rememberSaveable {
        mutableStateOf(categories[0])
    }
    val colorScheme = MaterialTheme.colorScheme
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        item {
            DiscoverHeader(colorScheme)
        }
        item {
            CategorySlider(
                colorScheme = colorScheme,
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )
        }
    }
}

@Composable
fun DiscoverHeader(colorScheme: ColorScheme) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Discover",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Get the latest news, information, tips and tricks according to your needs.",
            fontSize = 16.sp,
            color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
        )
    }
}

@Composable
fun CategorySlider(
    colorScheme: ColorScheme,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    Spacer(modifier = Modifier.height(32.dp))
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            val backgroundColor = if (isSelected) colorScheme.surfaceVariant else Color.Transparent
            val textColor = if (isSelected) colorScheme.onSurface else colorScheme.onSurfaceVariant.copy(alpha = 0.7f)

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(backgroundColor)
                    .clickable { onCategorySelected(category) }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = category,
                    color = textColor,
                    fontSize = 14.sp,
                    fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
                )
            }
        }
    }
}