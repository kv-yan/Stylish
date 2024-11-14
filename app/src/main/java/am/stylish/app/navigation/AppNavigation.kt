package am.stylish.app.navigation

import am.stylish.app.auth.navigation.AuthMainScreen
import am.stylish.app.landing.presentation.LandingScreens
import am.stylish.app.main.get_started.GetStarted
import am.stylish.app.main.navigation.presentation.component.MainScreenNavigation
import am.stylish.app.navigation.destination.AppDestination
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(modifier: Modifier = Modifier, startDestination: AppDestination) {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            modifier = modifier.background(Color.White),
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
                MainScreenNavigation()
            }

            composable<AppDestination.GetStarted>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {
                GetStarted{
                    navController.navigate(it)
                }
            }
        }
    }
}
