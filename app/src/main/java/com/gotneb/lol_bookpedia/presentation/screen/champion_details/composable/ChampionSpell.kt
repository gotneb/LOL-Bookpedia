package com.gotneb.lol_bookpedia.presentation.screen.champion_details.composable

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gotneb.lol_bookpedia.data.repository.API
import com.gotneb.lol_bookpedia.domain.model.SpellModel

@Composable
fun ChampionSpell(
    spell: SpellModel,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = {
          Text(text = spell.name ?: "")
        },
        supportingContent = {
            Text(text = spell.description ?: "")
        },
        leadingContent = {
            AsyncImage(
                model = API.IMG_ABILITY_URL + "${spell.id}.png",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        },
        modifier = modifier
    )
}