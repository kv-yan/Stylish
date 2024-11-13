package am.stylish.app.main.navigation.presentation.component

import am.stylish.app.main.navigation.domain.MainScreenDestination
import am.stylish.app.main.navigation.presentation.component.bottom_bar.BottomNavigationBar
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
fun MainScreenNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .navigationBarsPadding(),
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController,
            )
        }
    ) {
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
            navController = navController,
            startDestination = MainScreenDestination.Home,
        ) {
            composable<MainScreenDestination.Home> { Text("Home") }
            composable<MainScreenDestination.Wishlist> { Text("Wishlist") }
            composable<MainScreenDestination.Cart> { Text("Cart") }
            composable<MainScreenDestination.Search> { Text("Search") }
            composable<MainScreenDestination.Settings> { Text("Settings") }
        }
    }
}