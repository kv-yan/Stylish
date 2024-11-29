package am.stylish.app.navigation

import am.stylish.app.auth.navigation.AuthMainScreen
import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_presentation.components.snackbar.AppSnackbar
import am.stylish.app.common_presentation.components.snackbar.SnackbarState
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.utils.test_mock_data.mockPageProductData
import am.stylish.app.landing.presentation.LandingScreens
import am.stylish.app.main.get_started.GetStarted
import am.stylish.app.main.navigation.MainScreenNavigation
import am.stylish.app.navigation.destination.AppDestination
import am.stylish.app.product_details.presentation.ProductDetailsScreen
import am.stylish.app.special_offer_details.presentation.SpecialOfferDetailsScreen
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier, startDestination: AppDestination
) {
    var snackbarState by remember { mutableStateOf<SnackbarState>(SnackbarState.Success()) }
    val showingSnackbar = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        AppNavigationContent(modifier = modifier,
            startDestination = startDestination,
            onSnackbarShown = {
                snackbarState = it
                showingSnackbar.value = true
            })

        AppSnackbar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            state = snackbarState,
            isShown = showingSnackbar
        )
    }
}

@Composable
private fun AppNavigationContent(
    modifier: Modifier = Modifier,
    startDestination: AppDestination,
    onSnackbarShown: (SnackbarState) -> Unit = {},
) {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            modifier = modifier.background(SoftWhite),
            navController = navController,
            startDestination = startDestination,
        ) {
            composable<AppDestination.Landing>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {
                LandingScreens(Modifier.padding(innerPadding)) {
                    navController.navigate(AppDestination.Auth)
                }
            }

            composable<AppDestination.Auth>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {
                AuthMainScreen(Modifier.padding(innerPadding)) {
                    navController.navigate(AppDestination.GetStarted)
                }
            }

            composable<AppDestination.Main>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {
                MainScreenNavigation(onSnackbarShown = onSnackbarShown,
                    navigateToSpecialOffer = { offer ->
                        navController.navigate(AppDestination.SpecialOfferDetails(offer.offerId))
                    },
                    navigateToProductDetails = {
                        navController.navigate(AppDestination.ProductDetails(it.id))
                    })
            }

            composable<AppDestination.GetStarted>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {
                GetStarted {
                    navController.navigate(it)
                }
            }

            composable<AppDestination.SpecialOfferDetails>(enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                )
            }, exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                )
            }, popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                )
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                )
            }) { entry ->
                val specialOfferId =
                    entry.toRoute<AppDestination.SpecialOfferDetails>().specialOfferId
                val specialOffer = mockPageProductData.find {
                    (it as? PageProduct.PageSpecialOffer)?.specialOffer?.offerId == specialOfferId
                } as PageProduct.PageSpecialOffer

                SpecialOfferDetailsScreen(specialOffer = specialOffer.specialOffer, onBackClick = {
                    navController.navigateUp()
                })
            }

            composable<AppDestination.ProductDetails>(enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                )
            }, exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                )
            }, popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                )
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                )
            }) {
                val productId = it.toRoute<AppDestination.ProductDetails>().productId
                ProductDetailsScreen(productId = productId,
                    onBackClick = { navController.navigateUp() },
                    onProductClick = { product ->
                        navController.navigate(AppDestination.ProductDetails(product.id))
                    },
                    onSnackbarShown = onSnackbarShown
                )
            }
        }
    }
}
