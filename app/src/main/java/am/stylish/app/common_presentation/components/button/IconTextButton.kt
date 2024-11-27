package am.stylish.app.common_presentation.components.button

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.CloudGray
import am.stylish.app.common_presentation.ui.theme.ProductTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.common_presentation.ui.theme.Shape8
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IconTextButton(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_visibility,
    contentTint: Color = Color.Black,
    text: String = "",
    borderColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    shape: Shape = Shape4,
    onClick: () -> Unit = {}
) {
    Box(modifier = modifier
        .clip(shape)
        .border(width = 1.dp, color = borderColor, shape = shape)
        .background(backgroundColor)
        .clickable { onClick() }) {

        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = contentTint,
            )

            Text(
                text = text,
                color = contentTint,
                style = ProductTitleTextStyle,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun IconTextButtonPrev() {
    Row(Modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        IconTextButton(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_visibility,
            contentTint = Color.Black,
            text = "View Similar",
            borderColor = CloudGray,
            backgroundColor = Color.White,
            shape = Shape8,
        ) { }
        IconTextButton(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_compere_product,
            contentTint = Color.Black,
            text = "Add to Compare",
            borderColor = CloudGray,
            backgroundColor = Color.White,
            shape = Shape8,
        ) { }
    }
}