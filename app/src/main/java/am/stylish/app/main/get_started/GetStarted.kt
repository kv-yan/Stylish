package am.stylish.app.main.get_started

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.ui.theme.GradientColors
import am.stylish.app.navigation.destination.AppDestination
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GetStarted(modifier: Modifier = Modifier, navigateToMainScreen: (AppDestination) -> Unit) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(RectangleShape),
            painter = painterResource(id = R.drawable.bg_get_started),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = GradientColors
                        )
                    )
            ) {
                Column(
                    modifier = Modifier.padding(50.dp, 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        stringResource(R.string.you_want_authentic_here_you_go),
                        color = Color.White,
                        fontSize = 34.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold))
                    )
                    Text(
                        modifier = Modifier.padding(top = 20.dp),
                        text = stringResource(R.string.find_it_here_buy_it_now),
                        color = Color.White,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular))
                    )
                    SolidButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        text = stringResource(R.string.get_started)
                    ) {
                        navigateToMainScreen(AppDestination.Main)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetStartedPreview() {
    GetStarted {}
}