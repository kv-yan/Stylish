package am.stylish.app.navigation.destination

import kotlinx.serialization.Serializable

sealed class AppDestination {
    @Serializable
    data object Landing : AppDestination()

    @Serializable
    data object Auth : AppDestination()

    @Serializable
    data object Main : AppDestination()

    @Serializable
    data object GetStarted : AppDestination()

    @Serializable
    data class SpecialOfferDetails(val specialOfferId: String) : AppDestination()

    @Serializable
    data class ProductDetails(val productId: String) : AppDestination()
}