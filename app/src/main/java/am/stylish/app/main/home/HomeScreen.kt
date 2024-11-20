package am.stylish.app.main.home

import am.stylish.app.common_presentation.components.product_list.ProductListWithSpecialOffers
import am.stylish.app.common_presentation.utils.test_mock_data.mockPageProductData
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // TODO: add here action bar , and all screen components
    ProductListWithSpecialOffers(
        modifier = modifier.fillMaxSize(),
        products = mockPageProductData
    )
}