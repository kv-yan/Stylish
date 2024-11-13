package am.stylish.app.main.navigation.domain

import kotlinx.serialization.Serializable

sealed class MainScreenDestination {
    @Serializable
    data object Home : MainScreenDestination()

    @Serializable
    data object Wishlist : MainScreenDestination()

    @Serializable
    data object Cart : MainScreenDestination()

    @Serializable
    data object Search : MainScreenDestination()

    @Serializable
    data object Settings : MainScreenDestination()
}