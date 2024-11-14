package am.stylish.app.main.get_started

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.SolidButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun GetStarted() {
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(Unit) {
        systemUiController.isSystemBarsVisible = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Image(
            painter = painterResource(id = R.drawable.get_started),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .clip(RectangleShape)
        )
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Box(modifier = Modifier.wrapContentSize()) {
                Image(
                    painter = painterResource(id = R.drawable.get_started_shadow),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .matchParentSize()
                )
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(50.dp, 30.dp),
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
                        text = stringResource(R.string.find_it_here_buy_it_now),
                        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
                        color = Color.White,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular))
                    )
                    SolidButton(
                        text = "Get Started",
                        modifier = Modifier
                            .padding(0.dp, 40.dp, 0.dp, 0.dp)
                            .height(55.dp)
                            .width(279.dp)
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GetStartedPreview() {
    GetStarted()
}

