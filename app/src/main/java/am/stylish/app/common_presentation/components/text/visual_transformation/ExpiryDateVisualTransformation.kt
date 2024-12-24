package am.stylish.app.common_presentation.components.text.visual_transformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class ExpiryDateVisualTransformation(
) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.take(4) // Limit to 4 characters
        val formatted = buildString {
            for (i in trimmed.indices) {
                if (i == 2) append(" / ") // Add separator after first two characters
                append(trimmed[i])
            }
        }

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 4 -> offset + 3 // Account for " / "
                    else -> 7 // Prevent crashes for invalid offsets
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset in 3..6 -> offset - 3
                    else -> 4 // Prevent crashes for invalid offsets
                }
            }
        }

        return TransformedText(AnnotatedString(formatted), offsetMapping)
    }
}
