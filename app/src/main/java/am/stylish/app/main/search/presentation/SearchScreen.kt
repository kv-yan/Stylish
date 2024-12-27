package am.stylish.app.main.search.presentation

import am.stylish.app.R
import am.stylish.app.common_presentation.components.action_bar.MainMenuActionBarContent
import am.stylish.app.common_presentation.components.items.ProductCategoryItem
import am.stylish.app.common_presentation.components.loading.AppLoadingAnimation
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductCategories
import am.stylish.app.main.search.domain.model.ProductCategory
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchViewModel: SearchViewModel = koinViewModel(),
    onCategoryClick: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onSnackBarShown: (SnackbarState) -> Unit = {}
) {
    val screenState by searchViewModel.screenState.collectAsState()

    when (screenState) {
        is SearchScreenState.Error -> {
            onSnackBarShown(
                SnackbarState.Error(
                    _message = R.string.something_went_wrong,
                    _icon = R.drawable.ic_error,
                )
            )
        }

        SearchScreenState.Loading ->
            AppLoadingAnimation()

        is SearchScreenState.Success -> {
            SearchScreenContent(
                modifier = modifier,
                onCategoryClick = onCategoryClick
            )
        }
    }

}

@Composable
fun SearchScreenContent(modifier: Modifier = Modifier, onCategoryClick: (String) -> Unit = {}) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SoftWhite)
            .systemBarsPadding()
    ) {

        MainMenuActionBarContent(
            modifier = Modifier.fillMaxWidth()
        )

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            text = "Search for products"
        )

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(mockProductCategories) { category ->
                ProductCategoryItem(
                    modifier = Modifier.fillMaxSize(),
                    productCategory = ProductCategory(
                        name = category.name, image = category.image
                    ),
                ) {
                    onCategoryClick(category.id)
                }
            }
        }

    }
}

@Preview
@Composable
private fun SearchScreenPrev() {
    SearchScreen()
}