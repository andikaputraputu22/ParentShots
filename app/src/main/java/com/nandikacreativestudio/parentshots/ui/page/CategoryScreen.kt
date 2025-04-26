package com.nandikacreativestudio.parentshots.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nandikacreativestudio.parentshots.data.model.Matches

@Composable
fun CategoryScreen() {
    val categories = listOf(
        "Highlight",
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
            .padding(top = 16.dp)
    ) {
        val matches = listOf(
            Matches(
                id = "1",
                title1 = "Positive Discipline",
                title2 = "Attachment Parenting",
                photo1 = "https://images.pexels.com/photos/3806953/pexels-photo-3806953.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                photo2 = "https://images.pexels.com/photos/1683975/pexels-photo-1683975.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                description1 = "An approach to parenting that focuses on encouraging good behavior through positive reinforcement rather than punishment.",
                description2 = "A style of parenting that emphasizes building a strong emotional bond between parent and child to foster trust and security."
            ),
            Matches(
                id = "2",
                title1 = "Helicopter Parenting",
                title2 = "Authoritative Parenting",
                photo1 = "https://images.pexels.com/photos/2701585/pexels-photo-2701585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                photo2 = "https://images.pexels.com/photos/4148842/pexels-photo-4148842.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                description1 = "A parenting style characterized by over-involvement in a child’s life, often hovering to ensure their success and safety.",
                description2 = "A balanced parenting approach that combines warmth and support with clear rules and high expectations."
            )
        )
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
        item {
            Highlight()
        }
        item {
            MatchesHeader()
        }
        items(matches) { item ->
            MatchesItem(item = item, colorScheme = colorScheme)
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
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            val backgroundColor = when {
                category == "Highlight" && isSelected -> Color.Blue
                isSelected -> colorScheme.surfaceVariant
                else -> colorScheme.surfaceVariant.copy(alpha = 0.3f)
            }
            val textColor = when {
                category == "Highlight" && isSelected -> Color.White
                isSelected -> colorScheme.onSurface
                else -> colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            }

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
                    fontWeight = if ( isSelected) FontWeight.SemiBold else FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun Highlight() {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(220.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .fillMaxHeight()
                .weight(2f)
        ) {
            AsyncImage(
                model = "https://images.pexels.com/photos/2253879/pexels-photo-2253879.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                AsyncImage(
                    model = "https://images.pexels.com/photos/3036405/pexels-photo-3036405.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                AsyncImage(
                    model = "https://images.pexels.com/photos/701016/pexels-photo-701016.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                ) {
                    Text(
                        text = "More",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun MatchesHeader() {
    Spacer(modifier = Modifier.height(8.dp))
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val colorScheme = MaterialTheme.colorScheme
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Matches",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "View all",
                fontSize = 14.sp,
                color = colorScheme.primary
            )
        }
    }
}

@Composable
fun MatchesItem(
    item: Matches,
    colorScheme: ColorScheme
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp),
                color = colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Versus",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorScheme.primary,
                modifier = Modifier
                    .rotate(-90f)
                    .padding(vertical = 4.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp),
                color = colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray)
                        .size(62.dp)
                ) {
                    AsyncImage(
                        model = item.photo1,
                        contentDescription = item.title1,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = item.title1,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = item.description1,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray)
                        .size(62.dp)
                ) {
                    AsyncImage(
                        model = item.photo2,
                        contentDescription = item.title2,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = item.title2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = item.description2,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}