package am.stylish.app.fullscreen_images

import am.stylish.app.R
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.button.IconButton
import am.stylish.app.common_presentation.components.pager.ZoomablePager
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.utils.test_mock_data.mockImageUrls
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ProductFullScreenImagesScreen(
    modifier: Modifier = Modifier,
    images: List<String>,
    initialPage: Int = 0,
    onCloseClick: () -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()
    val pagerState = rememberPagerState(initialPage = initialPage) { images.size }

    LaunchedEffect(Unit) {
        systemUiController.statusBarDarkContentEnabled = false
    }

    DisposableEffect(Unit) {
        onDispose {
            systemUiController.statusBarDarkContentEnabled = true
        }
    }


    Box(modifier = modifier.background(Color.Black)) {

        ZoomablePager(
            modifier = Modifier.fillMaxSize(),
            pagerState = pagerState,
            images = images
        )

        AppActionBar(modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .padding(4.dp)
            .align(Alignment.TopStart),
            showStartContent = true,
            showCenterContent = false,
            showEndContent = false,
            startContent = {
                IconButton(tint = Color.Black, icon = {
                    Icon(
                        imageVector = Icons.Default.Close, contentDescription = null
                    )
                }) {
                    onCloseClick()
                }
            }
        )

        Box(
            modifier = Modifier
                .padding(
                    bottom = 8.dp,
                    end = 8.dp,
                )
                .align(Alignment.BottomEnd)
        ) {
            Text(
                modifier = Modifier
                    .clip(Shape4)
                    .background(SoftWhite)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = stringResource(
                    id = R.string.product_image_position,
                    pagerState.currentPage + 1,
                    images.size
                ),
                style = ProductPriceTextStyle,
                fontSize = 14.sp,
            )
        }
    }
}


@Preview
@Composable
private fun ProductFullScreenImagesScreenPrev() {
    ProductFullScreenImagesScreen(images = mockImageUrls)
}