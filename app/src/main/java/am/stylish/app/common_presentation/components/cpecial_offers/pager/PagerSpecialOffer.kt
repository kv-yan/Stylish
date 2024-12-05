package am.stylish.app.common_presentation.components.cpecial_offers.pager

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.Shape12
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

@Composable
fun <T> PagerSpecialOffer(
    modifier: Modifier = Modifier,
    sourceList: List<T>,
    imageLoader: @Composable (T) -> Unit,
    extractColor: suspend (T) -> Color,
    onClick: () -> Unit = {}
) {
    val pagerState = rememberPagerState(initialPage = 0) { sourceList.size }
    val currentColor = remember { mutableStateOf(Color.Gray) }

    LaunchedEffect(pagerState.currentPage) {
        currentColor.value = extractColor(sourceList[pagerState.currentPage])
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .aspectRatio(1.5f)
                    .clickable { onClick() }
                    .clip(Shape12)
            ) {
                imageLoader(sourceList[page])
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in sourceList.indices) {
                val color =
                    if (pagerState.currentPage == i) currentColor.value else Color.LightGray

                Spacer(
                    modifier = Modifier
                        .size(18.dp, 10.dp)
                        .padding(horizontal = 4.dp)
                        .clip(CircleShape)
                        .background(color)
                )
            }

        }
    }
}

suspend fun extractDominantColorFromImage(imageUrl: String): Color {
    val bitmap = withContext(Dispatchers.IO) {
        val url = URL(imageUrl)
        BitmapFactory.decodeStream(url.openStream())
    }

    val palette = Palette.from(bitmap).generate()
    val dominantColor = palette.getDominantColor(Color.Gray.toArgb())

    return Color(dominantColor)
}


@Preview
@Composable
private fun PagerSpecialOfferPreview() {
    val context = LocalContext.current
    Column(verticalArrangement = Arrangement.spacedBy(48.dp)) {
        PagerSpecialOffer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            sourceList = listOf(
                "https://s.tmimgcdn.com/scr/1200x750/375400/special-offer-on-store-and-online-banner-design-template_375461-original.jpg",
                "https://img.freepik.com/free-vector/special-offer-modern-sale-banner-template_1017-20667.jpg",
                "https://static.vecteezy.com/system/resources/previews/001/381/216/non_2x/special-offer-sale-banner-with-megaphone-free-vector.jpg"
            ),
            imageLoader = { url ->
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(Shape12),
                    painter = rememberAsyncImagePainter(url),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                )
            },
            onClick = { /* Handle click */ },
            extractColor = { imageUrl ->
                extractDominantColorFromImage(imageUrl)
            }
        )

        PagerSpecialOffer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            sourceList = listOf(
                R.drawable.pager_special_offer,
                R.drawable.pager_special_offer,
                R.drawable.pager_special_offer,
            ),
            imageLoader = { resId ->
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(resId),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            },
            onClick = { /* Handle click */ },
            extractColor = { imageRes ->
                val bitmap = BitmapFactory.decodeResource(context.resources, imageRes)
                val palette = Palette.from(bitmap).generate()
                Color(palette.getDominantColor(Color.Gray.toArgb()))
            }
        )
    }
}