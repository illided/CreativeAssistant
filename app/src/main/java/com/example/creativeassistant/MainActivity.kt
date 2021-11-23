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