package am.stylish.app.landing.presentation

import LandingPager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun LandingScreens(
    modifier: Modifier = Modifier,
    viewModel: LandingViewModel = koinViewModel(),
    navigateToAuth: () -> Unit = {},
) {
    LandingPager(
        modifier = modifier.fillMaxSize(),
        benefitsList = viewModel.benefitsList,
        navigateToAuth = navigateToAuth,
    )
}