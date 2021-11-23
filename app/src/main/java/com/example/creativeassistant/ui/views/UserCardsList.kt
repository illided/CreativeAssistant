package com.example.creativeassistant.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.creativeassistant.model.Idea
import com.example.creativeassistant.ui.common.IdeaCardInList
import com.example.creativeassistant.ui.common.fakeIdeas
import com.example.creativeassistant.ui.theme.CreativeAssistantTheme

@Composable
fun UserCardsList(cards: List<Idea>, onClick: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(cards) { index, card ->
            IdeaCardInList(
                idea = card,
                onClick = { onClick(index) })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardListPreview() {
    CreativeAssistantTheme {
        UserCardsList(cards = fakeIdeas, onClick = {})
    }
}