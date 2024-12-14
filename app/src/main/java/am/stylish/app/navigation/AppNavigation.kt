package am.stylish.app.navigation

import am.stylish.app.add_payment_method.presentation.AddPaymentMethodScreen
import am.stylish.app.auth.navigation.AuthMainScreen
import am.stylish.app.checkout.presentation.CheckoutScreen
import am.stylish.app.common_presentation.components.snackbars.AppSnackbar
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.fullscreen_images.ProductFullScreenImagesScreen
import am.stylish.app.landing.presentation.LandingScreens
import am.stylish.app.main.get_started.GetStarted
import am.stylish.app.main.navigation.MainScreenNavigation
import am.stylish.app.navigation.destination.AppDestination
import am.stylish.app.navigation.nav_type.ListStringNavType
import am.stylish.app.order_details_screen.presentation.OrderDetailsScreen
import am.stylish.app.product_details.presentation.ProductDetailsScreen
import am.stylish.app.special_offer_details.presentation.SpecialOfferDetailsScreen
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlin.reflect.typeOf

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    startDestination: AppDestination
) {
    val snackBars = remember { mutableStateListOf<SnackbarState>() }

    Box(modifier = Modifier.fillMaxSize()) {

        AppNavigationContent(
            modifier = modifier,
            startDestination = startDestination,
            onSnackBarShown = { snackBarState ->
                snackBars.add(snackBarState)
            }
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 32.dp)
        ) {
            snackBars.forEachIndexed { index, state ->
                AppSnackbar(
                    modifier = Modifier
                        .offset(y = (index * 8).dp)
                        .zIndex(index.toFloat()),
                    state = state
                ) {
                    snackBars.remove(state)
                }
            }
        }
    }
}

@Composable
private fun AppNavigationContent(
    modifier: Modifier = Modifier,
    startDestination: AppDestination,
    onSnackBarShown: (SnackbarState) -> Unit = {},
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
                MainScreenNavigation(
                    onSnackBarShown = onSnackBarShown,
                    navigateToSpecialOffer = { offer ->
                        navController.navigate(AppDestination.SpecialOfferDetails(offer.offerId))
                    },
                    navigateToProductDetails = {
                        navController.navigate(AppDestination.ProductDetails(it.id))
                    },
                    navigateToOrderDetails = {
                        navController.navigate(AppDestination.OrderDetails(it))
                    }
                )
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

            composable<AppDestination.SpecialOfferDetails>(
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                    )
                },
                popEnterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                    )
                },
                popExitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                    )
                },
            ) { entry ->
                val specialOfferId =
                    entry.toRoute<AppDestination.SpecialOfferDetails>().specialOfferId

                SpecialOfferDetailsScreen(
                    specialOfferId = specialOfferId,
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onProductClick = {
                        navController.navigate(AppDestination.ProductDetails(it.id))
                    },
                    onSnackBarShown = onSnackBarShown
                )
            }

            composable<AppDestination.ProductDetails>(
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                    )
                },
                popEnterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
                    )
                },
                popExitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { it }, animationSpec = tween(durationMillis = 300)
                    )
                },
            ) {
                val productId = it.toRoute<AppDestination.ProductDetails>().productId
                ProductDetailsScreen(
                    productId = productId,
                    onBackClick = { navController.navigateUp() },
                    onProductClick = { product ->
                        navController.navigate(AppDestination.ProductDetails(product.id))
                    },
                    onSnackBarShown = onSnackBarShown,
                    onImageClick = { images, position ->
                        navController.navigate(
                            AppDestination.ProductFullScreenImages(
                                images = images,
                                position = position
                            )
                        )
                    }
                )
            }

            composable<AppDestination.ProductFullScreenImages>(
                typeMap = mapOf(
                    typeOf<List<String>>() to ListStringNavType.listStringType,
                )
            ) {
                val images = it.toRoute<AppDestination.ProductFullScreenImages>().images
                val position = it.toRoute<AppDestination.ProductFullScreenImages>().position

                ProductFullScreenImagesScreen(
                    images = images,
                    initialPage = position
                ) {
                    navController.navigateUp()
                }
            }

            composable<AppDestination.OrderDetails>(
                typeMap = mapOf(
                    typeOf<List<String>>() to ListStringNavType.listStringType,
                )

            ) {
                val productIds = it.toRoute<AppDestination.OrderDetails>().productIds
                OrderDetailsScreen(
                    products = productIds,
                    onBackClick = { navController.navigateUp() },
                    onSnackBarShown = onSnackBarShown,
                    onPaymentClick = { totalPrice ->
                        navController.navigate(AppDestination.Checkout(totalPrice))
                    }
                )
            }

            composable<AppDestination.Checkout> {
                val totalPrice = it.toRoute<AppDestination.Checkout>().totalPrice
                CheckoutScreen(
                    orderPrice = totalPrice,
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onAddPaymentMethodClick = {
                        navController.navigate(AppDestination.AddPaymentMethod)
                    }
                )
            }


            composable<AppDestination.AddPaymentMethod> {
                AddPaymentMethodScreen(
                    onSnackBarShow = onSnackBarShown,
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}
