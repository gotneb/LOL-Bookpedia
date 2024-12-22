package com.gotneb.lol_bookpedia.presentation.screen.champion_details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.gotneb.lol_bookpedia.R
import com.gotneb.lol_bookpedia.data.repository.API
import com.gotneb.lol_bookpedia.domain.model.ChampionModel
import com.gotneb.lol_bookpedia.ui.theme.LOLBookpediaTheme

@Composable
fun ChampionHeader(
    champion: ChampionModel,
    modifier: Modifier = Modifier,
) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                text = champion.name ?: "",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        supportingContent = {
            Text(
                text = champion.tags.firstOrNull() ?: ""
            )
        },
        leadingContent = {
            AsyncImage(
                model = API.IMG_SQUARE_URL + "${champion.name}.png",
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        trailingContent = {
            Text(
                text = champion.title ?: "",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    )
}