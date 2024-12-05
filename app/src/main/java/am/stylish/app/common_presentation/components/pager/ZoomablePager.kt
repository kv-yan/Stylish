package am.stylish.app.common_presentation.components.pager


import am.stylish.app.common_data.utils.getBitmapFromUrl
import am.stylish.app.common_presentation.components.image.ZoomableImage
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext

@Composable
fun ZoomablePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    images: List<String>,
) {
    val context = LocalContext.current
    val isZoomed = remember { mutableStateOf(false) }
    val bitmap = remember { mutableStateOf<ImageBitmap?>(null) }

    HorizontalPager(
        modifier = modifier, state = pagerState, userScrollEnabled = !isZoomed.value
    ) { page ->

        LaunchedEffect(page) {
            bitmap.value = getBitmapFromUrl(
                context = context, url = images[page]
            )
        }

        ZoomableImage(bitmap = bitmap.value) {
            isZoomed.value = it
        }

    }
}