package am.stylish.app.common_presentation.components.items

import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.GoldenAmber
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(rating: Float) {
    Row {
        repeat(5) { index ->
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = if (index < rating) GoldenAmber else CoolGray
            )
        }
    }
}
