package am.stylish.app.splash.presentation

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {

        Image(
            modifier = Modifier.size(124.dp, 100.dp),
            painter = painterResource(R.drawable.ic_stylish_logo),
            contentDescription = null
        )

        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(
                fontSize = 40.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.libre_caslon_text_bold)),
                fontWeight = FontWeight.W700,
                color = RoseRed,
            )
        )
    }
}