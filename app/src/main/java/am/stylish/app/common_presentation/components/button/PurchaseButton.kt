package am.stylish.app.common_presentation.components.button

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.DeepOceanBlue
import am.stylish.app.common_presentation.ui.theme.PurchaseButtonTextStyle
import am.stylish.app.common_presentation.ui.theme.SkyBlue
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PurchaseButton(
    text: String,
    icon: Int,
    brush: Brush,
    shadowColor: Color = Color.Black,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.clickable { onClick() }, contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .height(36.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 4.dp,
                        topEnd = 4.dp,
                    )
                )
                .background(
                    brush = brush
                ),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                modifier = Modifier.padding(56.dp, end = 16.dp),
                text = text,
                style = PurchaseButtonTextStyle
            )
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    brush = brush
                )
                .drawWithCache {
                    onDrawBehind {
                        drawRoundRect(
                            color = shadowColor.copy(alpha = 0.1f),
                            topLeft = Offset(-8f, -8f),
                            size = size.copy(width = size.width + 16, height = size.height + 16),
                            cornerRadius = CornerRadius(20f)
                        )
                    }
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(),
                painter = painterResource(icon),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}


@Preview
@Composable
private fun BuyButtonPrev() {
    PurchaseButton(
        text = "Buy Now",
        icon = R.drawable.ic_by_now,
        brush = Brush.verticalGradient(listOf(SkyBlue, DeepOceanBlue))
    )
}