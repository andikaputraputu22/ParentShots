package com.nandikacreativestudio.parentshots.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nandikacreativestudio.parentshots.data.model.Article
import com.nandikacreativestudio.parentshots.ui.component.CircularBackButton
import com.nandikacreativestudio.parentshots.ui.component.CircularFavoriteButton
import com.nandikacreativestudio.parentshots.ui.component.CircularPlayButton
import com.nandikacreativestudio.parentshots.ui.component.CircularShareButton

@Composable
fun DetailArticleScreen(
    id: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        HeaderMenu(
            onBackClick = {},
            onShareClick = {},
            onFavoriteClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            val article = Article(
                id = "2",
                title = "Secondary School Places: When Do Parents Find Out?",
                photo = "https://images.pexels.com/photos/3036405/pexels-photo-3036405.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                category = "Parenting",
                source = "Ananka",
                time = "3 hours ago",
                caption = "The newly renovated bridge connecting the two districts was officially opened to the public.",
                description = "On this day, environmental organisations from all over the world come together to highlight the urgent need to protect the many ecosystems that make up our environment.\n\nThese ecosystems are under attack from climate change and the natural disasters caused by rising temperatures: forest fires, floods and terrible storms. More than a million animal and plant species are in danger of extinction through loss of habitat, mainly due to human activity. This, in turn, is leading to outbreaks of deadly diseases that spread from wildlife to humans. On International Mother Earth Day, environmentalists call for action to reverse this damage."
            )
            item {
                ArticleHeaderImage(item = article)
            }
            item { 
                ArticleContent(item = article)
            }
        }
    }
}

@Composable
fun HeaderMenu(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircularBackButton(
            onClick = onBackClick
        )
        Row {
            CircularShareButton(
                onClick = onShareClick
            )
            Spacer(modifier = Modifier.width(8.dp))
            CircularFavoriteButton(
                onClick = onFavoriteClick
            )
        }
    }
}

@Composable
fun ArticleHeaderImage(
    item: Article
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        val colorScheme = MaterialTheme.colorScheme
        Text(
            text = item.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularPlayButton {
            }
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = item.category,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                    color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.source,
                        fontSize = 16.sp,
                        color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "\u2022",
                        fontSize = 12.sp,
                        color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = item.time,
                        fontSize = 14.sp,
                        color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
        ) {
            AsyncImage(
                model = item.photo,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.caption,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
        )
    }
}

@Composable
fun ArticleContent(
    item: Article
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
    ) {
        Text(
            text = item.description,
            fontSize = 18.sp
        )
    }
}