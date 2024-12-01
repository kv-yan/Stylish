package am.stylish.app.common_presentation.components.product_components

import am.stylish.app.common_presentation.ui.theme.CoralPink
import am.stylish.app.common_presentation.ui.theme.RegularDescriptionTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape4
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductSizeSection(
    modifier: Modifier = Modifier,
    sizeList: List<String>,
    selectedSize: String,
    onSizeClick: (String) -> Unit = {}
) {
    Column(modifier) {
        Text(text = "Size: $selectedSize", style = RegularDescriptionTextStyle, color = Color.Black)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (size in sizeList.indices) {
                val item = sizeList[size]
                ProductSizeItem(
                    modifier = Modifier,
                    isSelected = item == selectedSize,
                    text = item
                ) {
                    onSizeClick(item)
                }
            }
        }
    }
}

@Composable
fun ProductSizeItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    text: String,
    onSizeClick: (String) -> Unit = {}
) {
    val backgroundColor = if (isSelected) CoralPink else Color.White
    val textColor = if (isSelected) Color.White else CoralPink

    Box(
        modifier
            .clip(Shape4)
            .background(backgroundColor)
            .border(width = 1.dp, color = CoralPink, shape = Shape4),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = text,
            style = RegularDescriptionTextStyle,
            color = textColor
        )
    }
}