package com.example.creativeassistant.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creativeassistant.model.Idea
import com.example.creativeassistant.ui.theme.CreativeAssistantTheme
import com.example.creativeassistant.ui.theme.GeneratedIdeaCardTheme
import com.example.creativeassistant.ui.theme.UserIdeaCardTheme

@Composable
fun IdeaCardInList(idea: Idea, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Text(idea.idea,
            modifier = Modifier
                .clickable { onClick() }
                .padding(8.dp)
        )
    }
}


@Composable
fun GeneratedIdeaCard(modifier: Modifier = Modifier, initialIdea: Idea) {
    GeneratedIdeaCardTheme {
        Card(
            backgroundColor = MaterialTheme.colors.background,
            elevation = 4.dp,
            modifier = modifier
        ) {
            Column {
                Text(
                    "Сгенерированная зелибоба:",
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                )
                Text(
                    initialIdea.generatedFrom,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.fillMaxSize().padding(8.dp)
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
            elevation = 4.dp,
            modifier = modifier
        ) {
            Column {
                TextField(
                    value = ideaText,
                    textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                    onValueChange = {
                        ideaText = it
                        onIdeaChange(it)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                TextField(
                    placeholder = {
                        Text(
                            "Описание",
                            fontStyle = FontStyle.Italic,
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    textStyle = MaterialTheme.typography.body1,
                    value = descriptionText,
                    onValueChange = {
                        descriptionText = it
                        onDescriptionChange(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
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
            Idea(
                idea = "Я считаю необходимым купить слона",
                generatedFrom = "Ах как я люблю слонов",
                description = ""
            ),
            onClick = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RedactableCardPreview() {
    RedactableUserIdeaCard(initialIdea = fakeIdeas[0],
        onIdeaChange = {}, onDescriptionChange = {})
}