package am.stylish.app.main.navigation.presentation.component.bottom_bar

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.BottomBarItemTextStyle
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.main.navigation.domain.BottomBarDomain
import am.stylish.app.main.navigation.domain.MainScreenDestination
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy


@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    val home = BottomBarDomain("Home", R.drawable.ic_home, MainScreenDestination.Home)
    val wished = BottomBarDomain("Wishlist", R.drawable.ic_wishlist, MainScreenDestination.Wishlist)
    val search = BottomBarDomain("Search", R.drawable.ic_search, MainScreenDestination.Search)
    val setting = BottomBarDomain("Setting", R.drawable.ic_settings, MainScreenDestination.Settings)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val isInHomeScreen = currentDestination?.hierarchy?.any { destination ->
        destination.route == MainScreenDestination.Home::class.qualifiedName
    }
    val isInWishListScreen = currentDestination?.hierarchy?.any { destination ->
        destination.route == MainScreenDestination.Wishlist::class.qualifiedName
    }
    val isInCartScreen = currentDestination?.hierarchy?.any { destination ->
        destination.route == MainScreenDestination.Cart::class.qualifiedName
    }
    val isInSearchScreen = currentDestination?.hierarchy?.any { destination ->
        destination.route == MainScreenDestination.Search::class.qualifiedName
    }
    val isInSettingsScreen = currentDestination?.hierarchy?.any { destination ->
        destination.route == MainScreenDestination.Settings::class.qualifiedName
    }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomBarItem(
                item = home,
                isSelected = isInHomeScreen == true,
            ) {
                navController.navigate(it)
            }
            BottomBarItem(
                item = wished,
                isSelected = isInWishListScreen == true,
            ) {
                navController.navigate(it)
            }
            MiddleCartItem(
                modifier = Modifier.offset(y = (-6).dp),
                isSelected = isInCartScreen == true,
            ) {
                navController.navigate(it)
            }
            BottomBarItem(
                item = search,
                isSelected = isInSearchScreen == true,
            ) {
                navController.navigate(it)
            }
            BottomBarItem(
                item = setting,
                isSelected = isInSettingsScreen == true,
            ) {
                navController.navigate(it)
            }
        }

    }
}

@Composable
fun NavController.currentBackStackEntryAsState(): State<NavBackStackEntry?> {
    val currentBackStackEntry = remember { mutableStateOf(currentBackStackEntry) }

    LaunchedEffect(this) {
        currentBackStackEntryFlow.collect { entry ->
            currentBackStackEntry.value = entry
        }
    }

    return currentBackStackEntry
}

@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier,
    item: BottomBarDomain,
    isSelected: Boolean,
    navigateTo: (MainScreenDestination) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 12.dp)
            .clickable {
                navigateTo.invoke(item.route)
            },
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            tint = if (isSelected) RoseRed else Color.Black
        )
        Text(
            text = item.title,
            style = BottomBarItemTextStyle,
            color = if (isSelected) RoseRed else Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun MiddleCartItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: (MainScreenDestination) -> Unit,
) {
    Surface(modifier = modifier,
        shadowElevation = 4.dp,
        color = if (isSelected) RoseRed else Color.White,
        shape = CircleShape,
        onClick = {
            onClick(MainScreenDestination.Cart)
        }) {
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_shopping_cart),
                contentDescription = null,
                tint = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}