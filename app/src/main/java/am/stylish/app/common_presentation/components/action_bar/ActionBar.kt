package am.stylish.app.common_presentation.components.action_bar

import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

// TODO: Lilit please recreate this component
@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    isShowingBackIcon: Boolean = true,
    onBackClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (isShowingBackIcon) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
        if (title != null) {
            Text(
                text = title,
                style = AuthTitleTextStyle,
                color = Color.Black,
                fontSize = 18.sp,
            )
        }
    }
}