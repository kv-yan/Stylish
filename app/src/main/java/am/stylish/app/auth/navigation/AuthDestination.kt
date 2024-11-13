package am.stylish.app.auth.navigation

import kotlinx.serialization.Serializable

sealed class AuthDestination {

    @Serializable
    data object SignIn : AuthDestination()

    @Serializable
    data object SignUp : AuthDestination()

    @Serializable
    data object ForgotPassword : AuthDestination()
}