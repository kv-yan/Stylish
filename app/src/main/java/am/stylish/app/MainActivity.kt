package am.stylish.app

import am.stylish.app.navigation.AppNavigation
import am.stylish.app.navigation.destination.AppDestination
import am.stylish.app.splash.presentation.SplashScreen
import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowInsetsControllerCompat
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val activity = LocalContext.current as Activity
            val window = WindowInsetsControllerCompat(
                activity.window, activity.window.decorView
            )

            window.isAppearanceLightStatusBars = true
            window.isAppearanceLightNavigationBars = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                activity.window.isNavigationBarContrastEnforced = false
            }

            var showSplashScreen by remember { mutableStateOf(true) }

            LaunchedEffect(Unit) {
                delay(700)
                showSplashScreen = false
            }

            if (showSplashScreen) {
                SplashScreen()
            } else {
                AppNavigation(startDestination = AppDestination.Landing)
            }
        }
    }
}
