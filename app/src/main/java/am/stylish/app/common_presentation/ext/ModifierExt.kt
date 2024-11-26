package am.stylish.app.common_presentation.ext

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

fun Modifier.drawInnerShadow(shadowColor: Color): Modifier {
    return this.drawWithCache {
        onDrawBehind {
            drawRoundRect(
                color = shadowColor.copy(alpha = 0.3f),
                topLeft = Offset(-8f, -8f),
                size = size.copy(width = size.width + 16, height = size.height + 16),
                cornerRadius = CornerRadius(20f)
            )
        }
    }
}