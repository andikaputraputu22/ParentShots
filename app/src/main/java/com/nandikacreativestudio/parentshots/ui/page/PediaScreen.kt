package com.nandikacreativestudio.parentshots.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nandikacreativestudio.parentshots.data.model.Article
import com.nandikacreativestudio.parentshots.data.model.Pedia

@Composable
fun PediaScreen() {
    val pediaList = listOf(
        Pedia("1", "A", "100"),
        Pedia("2", "B", "120"),
        Pedia("3", "C", "130"),
        Pedia("4", "D", "140"),
        Pedia("5", "E", "150"),
        Pedia("6", "F", "160"),
        Pedia("7", "G", "170"),
        Pedia("8", "H", "180"),
        Pedia("9", "I", "190"),
        Pedia("10", "J", "134"),
        Pedia("11", "K", "133"),
        Pedia("12", "L", "112"),
        Pedia("13", "M", "189"),
        Pedia("14", "N", "145"),
        Pedia("15", "O", "176")
    )
    val articles = listOf(
        Article(
            id = "1",
            title = "Antepartum",
            photo = "https://images.pexels.com/photos/3806953/pexels-photo-3806953.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "An approach to parenting that focuses on encouraging good behavior through positive reinforcement rather than punishment."
        ),
        Article(
            id = "2",
            title = "Antenatal Care",
            photo = "https://images.pexels.com/photos/1683975/pexels-photo-1683975.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A style of parenting that emphasizes building a strong emotional bond between parent and child to foster trust and security."
        ),
        Article(
            id = "3",
            title = "Authority Parenting",
            photo = "https://images.pexels.com/photos/2701585/pexels-photo-2701585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A parenting style characterized by over-involvement in a child’s life, often hovering to ensure their success and safety."
        ),
        Article(
            id = "4",
            title = "Asetaminofen",
            photo = "https://images.pexels.com/photos/4148842/pexels-photo-4148842.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A balanced parenting approach that combines warmth and support with clear rules and high expectations."
        ),
        Article(
            id = "1",
            title = "Antepartum",
            photo = "https://images.pexels.com/photos/3806953/pexels-photo-3806953.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "An approach to parenting that focuses on encouraging good behavior through positive reinforcement rather than punishment."
        ),
        Article(
            id = "2",
            title = "Antenatal Care",
            photo = "https://images.pexels.com/photos/1683975/pexels-photo-1683975.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A style of parenting that emphasizes building a strong emotional bond between parent and child to foster trust and security."
        ),
        Article(
            id = "3",
            title = "Authority Parenting",
            photo = "https://images.pexels.com/photos/2701585/pexels-photo-2701585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A parenting style characterized by over-involvement in a child’s life, often hovering to ensure their success and safety."
        ),
        Article(
            id = "4",
            title = "Asetaminofen",
            photo = "https://images.pexels.com/photos/4148842/pexels-photo-4148842.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A balanced parenting approach that combines warmth and support with clear rules and high expectations."
        ),
        Article(
            id = "1",
            title = "Antepartum",
            photo = "https://images.pexels.com/photos/3806953/pexels-photo-3806953.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "An approach to parenting that focuses on encouraging good behavior through positive reinforcement rather than punishment."
        ),
        Article(
            id = "2",
            title = "Antenatal Care",
            photo = "https://images.pexels.com/photos/1683975/pexels-photo-1683975.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A style of parenting that emphasizes building a strong emotional bond between parent and child to foster trust and security."
        ),
        Article(
            id = "3",
            title = "Authority Parenting",
            photo = "https://images.pexels.com/photos/2701585/pexels-photo-2701585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A parenting style characterized by over-involvement in a child’s life, often hovering to ensure their success and safety."
        ),
        Article(
            id = "4",
            title = "Asetaminofen",
            photo = "https://images.pexels.com/photos/4148842/pexels-photo-4148842.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            description = "A balanced parenting approach that combines warmth and support with clear rules and high expectations."
        )
    )
    var selectedPedia by rememberSaveable {
        mutableStateOf(pediaList[0].key)
    }
    val colorScheme = MaterialTheme.colorScheme
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        PediaHeader(colorScheme = colorScheme)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 24.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
            ) {
                PediaSlider(
                    colorScheme = colorScheme,
                    pediaList = pediaList,
                    selectedPedia = selectedPedia,
                    onPediaSelected = { selectedPedia = it }
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.85f)
                    .fillMaxHeight()
            ) {
                PediaList(colorScheme = colorScheme, articles = articles)
            }
        }
    }
}

@Composable
fun PediaHeader(colorScheme: ColorScheme) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Pedia",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(colorScheme = colorScheme)
    }
}

@Composable
fun SearchBar(
    colorScheme: ColorScheme
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                shape = RoundedCornerShape(24.dp),
                color = colorScheme.surfaceVariant
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                tint = colorScheme.onSurface,
                contentDescription = "Search"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Search",
                fontSize = 16.sp,
                color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun PediaSlider(
    colorScheme: ColorScheme,
    pediaList: List<Pedia>,
    selectedPedia: String,
    onPediaSelected: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pediaList) { pedia ->
            val isSelected = pedia.key == selectedPedia
            val backgroundColor = if (isSelected) Color.Blue
            else colorScheme.surfaceVariant.copy(alpha = 0.3f)
            val textColor = if (isSelected) Color.White
            else colorScheme.onSurfaceVariant.copy(alpha = 0.7f)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(backgroundColor)
                    .clickable { onPediaSelected(pedia.key) }
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = pedia.key,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = textColor
                    )
                    Text(
                        text = pedia.count,
                        fontSize = 14.sp,
                        color = textColor
                    )
                }
            }
        }
    }
}

@Composable
fun PediaList(
    colorScheme: ColorScheme,
    articles: List<Article>
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        VerticalDivider(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight(),
            color = colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(articles) { article ->
                PediaItem(colorScheme = colorScheme, article = article)
            }
        }
    }
}

@Composable
fun PediaItem(
    colorScheme: ColorScheme,
    article: Article
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .size(90.dp)
        ) {
            AsyncImage(
                model = article.photo,
                contentDescription = article.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
        ) {
            Text(
                text = article.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = article.description,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        }
    }
}