package am.stylish.app.main.navigation

import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.main.cart.presentation.CartScreen
import am.stylish.app.main.home.presentation.HomeScreen
import am.stylish.app.main.navigation.domain.MainScreenDestination
import am.stylish.app.main.navigation.presentation.component.bottom_bar.BottomNavigationBar
import am.stylish.app.main.search.presentation.SearchScreen
import am.stylish.app.main.wishlist.presentation.WishlistScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreenNavigation(
    modifier: Modifier = Modifier,
    navigateToProductDetails: (Product) -> Unit = {},
    navigateToSpecialOffer: (SpecialOffer) -> Unit = {},
    onSnackBarShown: (SnackbarState) -> Unit = {},
    navigateToOrderDetails: (List<String>) -> Unit = {},
    navigateToCategoryDetails: (String) -> Unit = {}
) {
    val navController = rememberNavController()

    Scaffold(modifier = modifier
        .fillMaxSize()
        .background(SoftWhite)
        .navigationBarsPadding(),
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController,
            )
        }) {
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
            navController = navController,
            startDestination = MainScreenDestination.Home,
        ) {
            composable<MainScreenDestination.Home> {
                HomeScreen(
                    onSpecialOfferClick = navigateToSpecialOffer,
                    onProductClick = navigateToProductDetails,
                    onSnackbarShown = onSnackBarShown,
                )
            }

            composable<MainScreenDestination.Wishlist> {
                WishlistScreen(
                    onProductClick = navigateToProductDetails,
                    onSnackbarShown = onSnackBarShown
                )
            }

            composable<MainScreenDestination.Cart> {
                CartScreen(
                    onProductClick = navigateToProductDetails,
                    onSnackbarShown = onSnackBarShown,
                    onBackClick = { navController.navigateUp() },
                    navigateToOrderDetails = navigateToOrderDetails
                )
            }

            composable<MainScreenDestination.Search> { SearchScreen(onCategoryClick = navigateToCategoryDetails) }

            composable<MainScreenDestination.Settings> { Text("Settings") }
        }
    }
}

