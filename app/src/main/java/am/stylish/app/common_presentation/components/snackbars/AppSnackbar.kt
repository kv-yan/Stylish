package am.stylish.app.common_presentation.components.snackbars;

import am.stylish.app.common_presentation.ui.theme.ForestGreen
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.Shape10
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AppSnackbar(
    modifier: Modifier = Modifier,
    state: SnackbarState,
    onDismiss: (SnackbarState) -> Unit = {}
) {
    var isShown by remember { mutableStateOf(false) }
    LaunchedEffect(state) {
        isShown = true
        delay(1500)
        isShown = false
        delay(200)
        onDismiss(state)
    }

    AnimatedVisibility(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        visible = isShown,
        enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut()
    ) {
        val (backgroundColor, textColor, iconColor) = when (state) {
            is SnackbarState.Error -> Triple(RoseRed, Color.White, Color.White)
            is SnackbarState.Success -> Triple(SoftWhite, Color.Black, ForestGreen)
        }

        Card(
            modifier = Modifier.padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = Shape10,
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor,
                contentColor = textColor
            )
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                state.icon?.let { iconRes ->
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = null,
                        tint = iconColor
                    )
                }

                Text(
                    text = stringResource(state.message),
                    modifier = Modifier.weight(1f),
                    style = ProductPriceTextStyle,
                    color = textColor
                )
            }
        }
    }
}