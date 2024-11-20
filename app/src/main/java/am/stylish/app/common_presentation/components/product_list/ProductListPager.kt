package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.model.Product
import am.stylish.app.common_presentation.components.items.ProductPagerItem
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.utils.test_mock_data.productsMockData
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun ProductListPager(
    modifier: Modifier = Modifier,
    products: List<Product>,
    isShowingController: Boolean = true
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = modifier) {
        LazyRow(
            state = listState,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(products) { item ->
                ProductPagerItem(
                    modifier = Modifier.widthIn(min = 170.dp, max = 170.dp),
                    product = item
                )
            }
        }

        // Animate Start Button visibility
        AnimatedVisibility(
            visible = isShowingController && listState.firstVisibleItemIndex > 0,
            modifier = Modifier.align(Alignment.CenterStart),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            IconButton(
                modifier = Modifier.padding(start = 16.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = CoolGray.copy(alpha = 0.7f), contentColor = Color.Black
                ),
                onClick = {
                    coroutineScope.launch {
                        val currentIndex = listState.firstVisibleItemIndex
                        if (currentIndex > 0) listState.animateScrollToItem(currentIndex - 1)
                    }
                },
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        }

        // Animate Forward Button visibility
        AnimatedVisibility(
            visible = isShowingController && listState.firstVisibleItemIndex < products.size - 1,
            modifier = Modifier.align(Alignment.CenterEnd),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            IconButton(
                modifier = Modifier.padding(16.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = CoolGray.copy(alpha = 0.7f), contentColor = Color.Black
                ),
                onClick = {
                    coroutineScope.launch {
                        val currentIndex = listState.firstVisibleItemIndex
                        if (currentIndex < products.size - 1) {
                            listState.animateScrollToItem(currentIndex + 1)
                        }
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductListPagerPrev() {
    ProductListPager(modifier = Modifier.fillMaxWidth(), products = productsMockData)
}