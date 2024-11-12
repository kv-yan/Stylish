package am.stylish.app.navigation

import am.stylish.app.landing.presentation.LandingScreens
import am.stylish.app.navigation.destination.AppDestination
import androidx.compose.foundation.background
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

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
                .background(Color.White)
                .padding(innerPadding),
        ) {

            composable<AppDestination.Landing>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {
                LandingScreens {
                    navController.navigate(AppDestination.Auth)
                }
            }

            composable<AppDestination.Auth>(
                enterTransition = { null },
                exitTransition = { null },
                popEnterTransition = { null },
            ) {

            }
        }
    }
}
