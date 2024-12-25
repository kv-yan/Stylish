package am.stylish.app.common_presentation.components.action_bar

import am.stylish.app.common_presentation.components.button.IconButton
import am.stylish.app.common_presentation.components.text.AppLogoWithText
import am.stylish.app.common_presentation.ui.theme.ActionBarLogoTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppActionBar(
    modifier: Modifier = Modifier,
    showCenterContent: Boolean = true,
    showStartContent: Boolean = false,
    showEndContent: Boolean = false,
    centerContent: @Composable () -> Unit = {},
    endContent: @Composable () -> Unit = {},
    startContent: @Composable () -> Unit = {},
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        if (showCenterContent) {
            centerContent()
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showStartContent) {
                startContent()
            } else {
                Spacer(Modifier)
            }

            if (showEndContent) {
                endContent()
            }
        }
    }
}

@Preview
@Composable
private fun AppActionBarPrev(modifier: Modifier = Modifier) {
    // main screen action bar
    AppActionBar(
        modifier = Modifier.fillMaxWidth(),
        showCenterContent = true,
        showStartContent = false,
        showEndContent = false,
        centerContent = {
            AppLogoWithText(
                textStyle = ActionBarLogoTextStyle,
                iconHeight = 32
            )
        },
        startContent = {
            IconButton(icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = null
                )
            }) { }
        },
        endContent = {
            IconButton(icon = {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = null
                )
            }) {}
        }
    )
}