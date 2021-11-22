package com.example.creativeassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.creativeassistant.ui.theme.CreativeAssistantTheme
import com.example.creativeassistant.ui.views.CardRedactorPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreativeAssistantTheme {
                CardRedactorPreview()
            }
        }
    }
}


//@Preview
//@Composable
//fun MyPreview() {
//    IdeaCard(idea = "Купить слона", generatedFrom = "Любовь к слонам у меня с детства!")
//}