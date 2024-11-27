package am.stylish.app.common_presentation.components.action_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

// TODO: Lilit please recreate this component
@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    isShowingBackIcon: Boolean = true,
    onBackClick: () -> Unit = {},
    onCartClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
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

        IconButton(onClick = { onCartClick() }) {
            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}