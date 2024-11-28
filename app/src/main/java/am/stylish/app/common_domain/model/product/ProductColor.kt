package am.stylish.app.common_domain.model.product

import androidx.compose.ui.graphics.Color

data class ProductColor(
    val colorName: String,
    val colorCode: String,
)

fun ProductColor.toComposeColor(): Color {
    return Color(android.graphics.Color.parseColor(this.colorCode))
}