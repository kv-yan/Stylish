package am.stylish.app.common_presentation.components.search

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.DarkGrayText
import am.stylish.app.common_presentation.ui.theme.LightGrayBackground
import am.stylish.app.common_presentation.ui.theme.MediumGrayBorder
import am.stylish.app.common_presentation.ui.theme.Shape10
import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String = "",
) {
    var textFieldValue by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val recognizedText =
                result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.firstOrNull()
            recognizedText?.let {
                textFieldValue = it
            }
        }
    }

    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (isFocused) MediumGrayBorder else MediumGrayBorder.copy(alpha = 0.5f),
                shape = Shape10
            )
            .clip(Shape10)
            .background(
                if (isFocused) LightGrayBackground
                else LightGrayBackground.copy(alpha = 0.3f)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = stringResource(R.string.search),
                tint = CoolGray
            )

            BasicTextField(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .weight(1f)
                    .onFocusChanged { isFocused = it.isFocused },
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                singleLine = true,
                cursorBrush = SolidColor(DarkGrayText),
                textStyle = TextStyle(color = DarkGrayText),
                decorationBox = { innerTextField ->
                    if (textFieldValue.isEmpty()) {
                        Text(
                            text = text, color = DarkGrayText.copy(alpha = 0.5f)
                        )
                    }
                    innerTextField()
                },
            )

            IconButton(onClick = {
                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                    putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                    )
                    putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
                    putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now...")
                }
                speechRecognizerLauncher.launch(intent)
            }) {
                Icon(
                    painter = painterResource(R.drawable.ic_microphone),
                    contentDescription = stringResource(R.string.voice_search),
                    tint = CoolGray
                )
            }
        }
    }
}


@Preview
@Composable
private fun SearchBarPrev() {
    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.search_any_product),
    )
}