package am.stylish.app.auth.navigation

import am.stylish.app.auth.sign_in.presentation.SignInScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AuthMainScreen(modifier: Modifier = Modifier, navigateToMain: () -> Unit) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        navController = navController,
        startDestination = AuthDestination.SignIn
    ) {
        composable<AuthDestination.SignIn> {
            SignInScreen(
                navigateToSignUp = {
                    navController.navigate(AuthDestination.SignUp)
                },
                navigateToForgotPassword = {
                    navController.navigate(AuthDestination.ForgotPassword)
                },
                navigateToMain = navigateToMain
            )
        }
        composable<AuthDestination.SignUp> {}
        composable<AuthDestination.ForgotPassword> {}
    }
}