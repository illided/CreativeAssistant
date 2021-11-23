package com.example.creativeassistant.ui.views

import androidx.compose.runtime.*
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.creativeassistant.model.Idea
import com.example.creativeassistant.ui.common.fakeIdeas
import com.example.creativeassistant.ui.theme.CreativeAssistantTheme


@Composable
fun CardView(
    onIdeaTitleChange: (Int, String) -> Unit,
    onIdeaDescriptionChange: (Int, String) -> Unit
) {
    val navController = rememberNavController()
    var ideaId by remember { mutableStateOf(-1) }
    NavHost(navController = navController, startDestination = "userCardList") {
        composable("userCardList") {
            UserCardsList(cards = fakeIdeas,
                onClick = {
                    ideaId = it
                    navController.navigate("cardRedactor")
                })
        }
        composable("cardRedactor") {
            CardRedactor(initialIdea = fakeIdeas[ideaId],
                onIdeaChange = { title ->
                    onIdeaTitleChange(ideaId, title)
                },
                onDescriptionChange = { description ->
                    onIdeaDescriptionChange(ideaId, description)
                })
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardViewPreview() {
    CreativeAssistantTheme {
        CardView(onIdeaDescriptionChange = { id, des ->
            println("Idea #$id new description: $des")
        }, onIdeaTitleChange = { id, title ->
            println("Idea #$id new title $title")
        })
    }
}