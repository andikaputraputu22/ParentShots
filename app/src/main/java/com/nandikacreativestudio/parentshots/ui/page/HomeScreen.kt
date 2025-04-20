package com.nandikacreativestudio.parentshots.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nandikacreativestudio.parentshots.data.model.Article
import com.nandikacreativestudio.parentshots.ui.component.CircularFavoriteButton
import com.nandikacreativestudio.parentshots.ui.component.CircularMenuButton
import com.nandikacreativestudio.parentshots.ui.component.CircularSearchButton

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TopMenuNavigation(
            onMenuClick = {},
            onSearchClick = {},
            onFavoriteClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            val articles = listOf(
                Article(
                    title = "What Training Do Volleyball Players Need?",
                    photo = "https://images.pexels.com/photos/2253879/pexels-photo-2253879.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    category = "Children",
                    source = "Ananka",
                    time = "2 hours ago"
                ),
                Article(
                    title = "Secondary School Places: When Do Parents Find Out?",
                    photo = "https://images.pexels.com/photos/3036405/pexels-photo-3036405.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    category = "Parenting",
                    source = "Ananka",
                    time = "3 hours ago"
                ),
                Article(
                    title = "6 Houses Destroyed in Massive Fire in Assams K",
                    photo = "https://images.pexels.com/photos/701016/pexels-photo-701016.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    category = "Play",
                    source = "Ananka",
                    time = "4 hours ago"
                )
            )
            item {
                TrendingBox(items = articles)
            }
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
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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

@Composable
fun TrendingBox(
    items: List<Article>
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.size })

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
                text = "Trending",
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
        HorizontalPager(
            state = pagerState,
            pageSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            page -> TrendingItem(item = items[page])
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(items.size) { index ->
                val selected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(
                            if (selected) colorScheme.primary
                            else colorScheme.onSurface.copy(alpha = 0.3f)
                        )
                ) {

                }
            }
        }
    }
}

@Composable
fun TrendingItem(
    item: Article
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        AsyncImage(
            model = item.photo,
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                        startY = 300f
                    )
                )
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = item.category,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .background(Color.Blue, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.source,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "\u2022",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = item.time,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Text(
                text = item.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}