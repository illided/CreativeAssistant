package com.example.creativeassistant.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.creativeassistant.model.Idea
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creativeassistant.R
import com.example.creativeassistant.ui.common.GeneratedIdeaCard
import com.example.creativeassistant.ui.common.RedactableUserIdeaCard
import com.example.creativeassistant.ui.theme.GeneratedIdeaCardTheme
import com.example.creativeassistant.ui.theme.LightIndigo
import com.example.creativeassistant.ui.theme.UserIdeaCardTheme
import com.example.creativeassistant.ui.theme.VeryLightGreen

@Composable
fun CardRedactor(
    initialIdea: Idea,
    onIdeaChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .scrollable(scrollState, Orientation.Vertical)
    ) {
        RedactableUserIdeaCard(
            modifier = Modifier
                .padding(4.dp)
                .weight(1f, fill = true),
            initialIdea = initialIdea,
            onIdeaChange = onIdeaChange,
            onDescriptionChange = onDescriptionChange
        )
        GeneratedIdeaCard(
            initialIdea = initialIdea, modifier = Modifier
                .padding(4.dp)
                .weight(0.2f, fill = false)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardRedactorPreview() {
    CardRedactor(
        initialIdea = Idea(
            stringResource(id = R.string.test_elephant_small),
            stringResource(id = R.string.test_elephant_medium),
            stringResource(id = R.string.test_elephant_large)
        ),
        onIdeaChange = { println("Idea changed. New: $it") },
        onDescriptionChange = { println("Description changed: $it") })
}