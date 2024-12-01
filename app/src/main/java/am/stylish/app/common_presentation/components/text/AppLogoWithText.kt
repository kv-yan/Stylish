package am.stylish.app.common_presentation.components.text

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.SplashLogoTextStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun AppLogoWithText(
    textStyle: TextStyle = SplashLogoTextStyle,
    iconHeight: Int = 100
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Image(
            modifier = Modifier.height(iconHeight.dp),
            painter = painterResource(R.drawable.ic_stylish_logo),
            contentDescription = null
        )

        Text(
            text = stringResource(R.string.action_bar_title),
            style = textStyle
        )
    }
}
