package am.stylish.app.common_presentation.components.action_bar

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.IconButton
import am.stylish.app.common_presentation.components.text.AppLogoWithText
import am.stylish.app.common_presentation.ui.theme.ActionBarLogoTextStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainMenuActionBarContent(modifier: Modifier = Modifier) {
    AppActionBar(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
        showCenterContent = true,
        showStartContent = true,
        showEndContent = true,
        centerContent = {
            AppLogoWithText(
                textStyle = ActionBarLogoTextStyle, iconHeight = 32
            )
        },
        startContent = {
            IconButton(icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_menu),
                    contentDescription = null,
                )
            }) { }
        },
        endContent = {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.ic_default_profile_placeholder),
                contentDescription = null,
            )
        }
    )
}