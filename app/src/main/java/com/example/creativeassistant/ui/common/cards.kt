package com.example.creativeassistant.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creativeassistant.model.Idea
import com.example.creativeassistant.ui.theme.CreativeAssistantTheme
import com.example.creativeassistant.ui.theme.GeneratedIdeaCardTheme
import com.example.creativeassistant.ui.theme.UserIdeaCardTheme

@Composable
fun IdeaCardInList(idea: String, generatedFrom: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Text(idea,
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick() }
        )
    }
}


@Composable
fun GeneratedIdeaCard(modifier: Modifier = Modifier, initialIdea: Idea) {
    GeneratedIdeaCardTheme {
        Card(backgroundColor = MaterialTheme.colors.background, modifier = modifier) {
            Column(Modifier.padding(6.dp)) {
                Text(
                    "Сгенерированная зелибоба:",
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    initialIdea.generatedFrom,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun RedactableUserIdeaCard(
    onIdeaChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    initialIdea: Idea = Idea("", "", "")
) {
    var ideaText by rememberSaveable { mutableStateOf(initialIdea.idea) }
    var descriptionText by rememberSaveable { mutableStateOf(initialIdea.description) }

    UserIdeaCardTheme {
        Card(
            backgroundColor = MaterialTheme.colors.background,
            modifier = modifier
        ) {
            Column(Modifier.padding(6.dp)) {
                OutlinedTextField(
                    label = { Text("Ваша идея", color = MaterialTheme.colors.onBackground) },
                    value = ideaText,
                    textStyle = TextStyle(fontSize = 20.sp),
                    onValueChange = {
                        ideaText = it
                        onIdeaChange(it)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    label = {
                        Text(
                            text = "Описание",
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    value = descriptionText,
                    onValueChange = {
                        descriptionText = it
                        onDescriptionChange(it)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview
@Composable
fun CardPreview() {
    CreativeAssistantTheme {
        IdeaCardInList(
            idea = "Я считаю необходимым купить слона",
            generatedFrom = "Ах как я люблю слонов",
            onClick = {})
    }
}