package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.screens.AppDetailsScreen
import com.example.myapplication.ui.screens.AppsListScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.APPS_LIST,
        modifier = modifier
    ) {
        composable(AppRoutes.APPS_LIST) {
            AppsListScreen(
                onAppClick = { appId ->
                    navController.navigateToDetails(appId)
                }
            )
        }

        composable(
            route = AppRoutes.APP_DETAILS_PATTERN,
            arguments = listOf(
                navArgument(AppRoutes.ARG_APP_ID) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getInt(AppRoutes.ARG_APP_ID) ?: -1

            AppDetailsScreen(
                appId = appId,
                onBack = { navController.navigateBack() }
            )
        }
    }
}