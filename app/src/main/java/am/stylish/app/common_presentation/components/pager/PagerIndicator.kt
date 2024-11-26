package am.stylish.app.common_presentation.components.pager

import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    size: Int,
    currentIndex: Int,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until size) {
            val isCurrentPage = currentIndex == i
            val color = if (isCurrentPage) RoseRed else Color.LightGray
            val height = if (isCurrentPage) 10.dp else 8.dp
            val width = if (isCurrentPage) 10.dp else 8.dp

            Spacer(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .height(height)
                    .width(width)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}