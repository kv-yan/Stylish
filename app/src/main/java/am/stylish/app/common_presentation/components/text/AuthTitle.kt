package am.stylish.app.common_presentation.components.text

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AuthTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        modifier = modifier,
        text = title,
        style = AuthTitleTextStyle
    )
}

@Preview
@Composable
private fun AuthTitlePreview() {
    AuthTitle(title = stringResource(R.string.welcome_back))
}