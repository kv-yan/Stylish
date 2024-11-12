import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.LightGray
import am.stylish.app.common_presentation.ui.theme.RegularTextStyle
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.DarkBlue
import am.stylish.app.common_presentation.ui.theme.TransparentGreen
import am.stylish.app.landing.domain.model.LandingUiItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import am.stylish.app.landing.presentation.pager.LandingPagerItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LandingPager(
    modifier: Modifier = Modifier, benefitsList: List<LandingUiItem>, navigateToAuth: () -> Unit
) {
    val pagerState = rememberPagerState(0, pageCount = { benefitsList.size })
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        PagerTopCounter(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            pagerState = pagerState
        ) {
            navigateToAuth()
        }

        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
        ) {
            LandingPagerItem(
                modifier = Modifier.fillMaxWidth(),
                item = benefitsList[it],
            )
        }

        PagerBottomController(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            pagerState = pagerState,
            scope = scope
        ) {
            navigateToAuth()
        }
    }
}

@Composable
private fun PagerTopCounter(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onSkipClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "${pagerState.currentPage + 1}/${pagerState.pageCount}",
            style = RegularTextStyle
        )
        TextButton(onClick = {
            onSkipClick()
        }) {
            Text(
                text = stringResource(R.string.skip),
                style = RegularTextStyle,
            )
        }
    }
}

@Composable
fun PagerBottomController(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    scope: CoroutineScope,
    navigateToAuth: () -> Unit
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (pagerState.currentPage != 0) {
            TextButton(onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            }) {
                Text(
                    text = stringResource(R.string.prev),
                    style = RegularTextStyle,
                    color = LightGray,
                    textAlign = TextAlign.Start
                )
            }
        } else {
            Text(text = stringResource(R.string.empty_string))
        }

        PagerDotIndicator(
            modifier = Modifier.fillMaxWidth(0.5f),
            pagerState = pagerState,
            totalPages = 3,
            selectedIndicator = DarkBlue,
            unselectedIndicator = TransparentGreen
        )
        TextButton(onClick = {
            scope.launch {
                if (pagerState.currentPage == pagerState.pageCount - 1) {
                    navigateToAuth()
                } else {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }

        }) {
            Text(
                text =
                if (pagerState.currentPage == pagerState.pageCount - 1)
                    stringResource(R.string.get_started)
                else stringResource(R.string.next),
                style = RegularTextStyle,
                color = RoseRed,
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun PagerDotIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    totalPages: Int,
    selectedIndicator: Color,
    unselectedIndicator: Color
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalPages) { page ->
            val isSelected = pagerState.currentPage == page
            val color = if (isSelected) selectedIndicator else unselectedIndicator
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(
                        height = 8.dp,
                        width = if (isSelected) 32.dp else 8.dp,
                    )
                    .background(color, shape = CircleShape)
            )
        }
    }
}