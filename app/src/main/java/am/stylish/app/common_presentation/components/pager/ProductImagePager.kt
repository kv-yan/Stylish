package am.stylish.app.common_presentation.components.pager

import am.stylish.app.common_presentation.ui.theme.Shape12
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch

@Composable
fun ProductImagePager(
    modifier: Modifier = Modifier,
    showingController: Boolean = true,
    sourceList: List<String>,
    onClick: (Int) -> Unit = {}
) {
    val pagerState = rememberPagerState(initialPage = 0) { sourceList.size }
    val currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = pagerState,
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .heightIn(min = 216.dp)
                        .aspectRatio(1.4f)
                        .clickable { onClick(pagerState.currentPage) }
                        .clip(Shape12)
                ) {

                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(Shape12),
                        painter = rememberAsyncImagePainter(sourceList[it]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                }
            }
            PagerIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        bottom = 12.dp,
                    ),
                size = sourceList.size,
                currentIndex = currentPage,
            )

        }

        if (showingController) {
            PagerController(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterEnd),
                isShowingPrev = pagerState.currentPage > 0,
                isShowingNext = pagerState.currentPage < sourceList.size - 1,
                onPrevClick = {
                    scope.launch {
                        if (pagerState.currentPage > 0)
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                onNextClick = {
                    scope.launch {
                        if (pagerState.currentPage < sourceList.size - 1)
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                })
        }
    }
}
