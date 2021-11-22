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
fun CardView(cards: List<Idea>, onClick: (Idea) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(cards) { card ->
            IdeaCardInList(
                idea = card.idea,
                generatedFrom = card.generatedFrom,
                onClick = { onClick(card) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardListPreview() {
    CreativeAssistantTheme {
        CardView(cards = fakeIdeas, onClick = {})
    }
}