package am.stylish.app

import am.stylish.app.navigation.AppNavigation
import am.stylish.app.navigation.destination.AppDestination
import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val activity = LocalContext.current as Activity
            val window = WindowInsetsControllerCompat(
                activity.window,
                activity.window.decorView
            )

            window.isAppearanceLightStatusBars = true
            window.isAppearanceLightNavigationBars = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                activity.window.isNavigationBarContrastEnforced = false
            }

            AppNavigation(startDestination = AppDestination.Auth)
        }
    }
}
