package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.items.ProductPagerItem
import am.stylish.app.common_presentation.components.pager.PagerController
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductsData
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun ProductListPager(
    modifier: Modifier = Modifier,
    products: List<Product>,
    isShowingController: Boolean = true,
    onProductClick: (Product) -> Unit = {},
    onWishedClick: (String) -> Unit = {}
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val firstVisibleItemIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }

    Box(modifier = modifier) {
        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min = 0.dp,
                    max = 450.dp
                ),
        ) {
            items(products) { item ->
                ProductPagerItem(
                    modifier = Modifier.widthIn(min = 170.dp, max = 170.dp),
                    product = item,
                    onWishlistClick = {
                        onWishedClick(it)
                    },
                    onClick = {
                        onProductClick(item)
                    })
            }
        }
        if (isShowingController) {
            PagerController(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterEnd),
                isShowingPrev = firstVisibleItemIndex > 0,
                isShowingNext = firstVisibleItemIndex < products.size - 1,
                onPrevClick = {
                    coroutineScope.launch {
                        val currentIndex = listState.firstVisibleItemIndex
                        if (currentIndex > 0) listState.animateScrollToItem(currentIndex - 1)
                    }
                },
                onNextClick = {
                    coroutineScope.launch {
                        val currentIndex = listState.firstVisibleItemIndex
                        if (currentIndex < products.size - 1) {
                            listState.animateScrollToItem(currentIndex + 1)
                        }
                    }
                })
        }
    }
}


@Preview
@Composable
private fun ProductListPagerPrev() {
    ProductListPager(
        modifier = Modifier.fillMaxWidth(), products = mockProductsData
    )
}