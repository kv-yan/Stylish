package am.stylish.app.common_presentation.components.text

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.CoralPink
import am.stylish.app.common_presentation.ui.theme.RegularDescriptionTextStyle
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ExpandableAnnotatedText(
    text: String,
    maxWords: Int = 40
) {
    var isExpanded by remember { mutableStateOf(false) }

    val words = text.split(" ")
    val shouldTruncate = words.size > maxWords
    val displayText = if (isExpanded || !shouldTruncate) {
        text
    } else {
        words.take(maxWords).joinToString(" ") + "..."
    }

    val annotatedText = buildAnnotatedString {
        append(displayText)
        if (shouldTruncate) {
            withStyle(
                style = SpanStyle(
                    color = CoralPink,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(if (isExpanded) stringResource(R.string.show_less) else stringResource(R.string.more))
            }
            addStringAnnotation(
                tag = "EXPAND_COLLAPSE",
                annotation = if (isExpanded) "Show Less" else "Show More",
                start = length - (if (isExpanded) 9 else 8),
                end = length
            )
        }
    }

    Text(
        text = annotatedText,
        style = RegularDescriptionTextStyle,
        modifier = Modifier
            .clickable { isExpanded = !isExpanded }
            .animateContentSize(),
        textAlign = TextAlign.Start
    )
}


@Preview
@Composable
private fun ExpandableAnnotatedTextPreview() {
    ExpandableAnnotatedText("This is an example text that should be expandable.")
}