package com.example.creativeassistant.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.creativeassistant.model.Idea
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        GeneratedIdeaCard(initialIdea = initialIdea)
        Spacer(modifier = Modifier.height(8.dp))
        RedactableUserIdeaCard(
            modifier = Modifier.fillMaxHeight(),
            initialIdea = initialIdea,
            onIdeaChange = onIdeaChange,
            onDescriptionChange = onDescriptionChange
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