package am.stylish.app.main.search.presentation

import am.stylish.app.common_presentation.components.action_bar.MainMenuActionBarContent
import am.stylish.app.common_presentation.components.items.ProductCategoryItem
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductCategories
import am.stylish.app.main.search.domain.ProductCategory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SoftWhite)
            .systemBarsPadding()
    ) {

        MainMenuActionBarContent(
            modifier = Modifier.fillMaxWidth()
        )

        SearchBar(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp), text = "Search for products")

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(mockProductCategories) { productType ->
                ProductCategoryItem(
                    modifier = Modifier.fillMaxSize(),
                    productCategory = ProductCategory(
                        name = productType.name,
                        image = productType.image
                    ),
                )
            }
        }

    }
}

@Preview
@Composable
private fun SearchScreenPrev() {
    SearchScreen()
}