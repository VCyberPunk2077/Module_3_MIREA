package ru.mirea.module3kotlin.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.mirea.module3kotlin.presentation.counter.AdaptiveHomeScreen
import ru.mirea.module3kotlin.presentation.counter.CounterViewModel
import ru.mirea.module3kotlin.presentation.counter.DetailsScreen
import ru.mirea.module3kotlin.presentation.feed.FeedScreen

private object Routes {
    const val Feed = "feed"
    const val Home = "home"
    const val Details = "details"
}

@Composable
fun AppNavigation(
    widthSizeClass: WindowWidthSizeClass,
    counterViewModel: CounterViewModel,
) {
    val navController = rememberNavController()
    val count = counterViewModel.count

    NavHost(
        navController = navController,
        startDestination = Routes.Feed,
        modifier = Modifier.fillMaxSize(),
    ) {
        composable(Routes.Feed) {
            FeedScreen(onOpenCounter = { navController.navigate(Routes.Home) })
        }
        composable(Routes.Home) {
            AdaptiveHomeScreen(
                widthSizeClass = widthSizeClass,
                count = count,
                onIncrement = counterViewModel::increment,
                onOpenDetails = { navController.navigate(Routes.Details) },
            )
        }
        composable(Routes.Details) {
            DetailsScreen(onBack = { navController.popBackStack() })
        }
    }
}

