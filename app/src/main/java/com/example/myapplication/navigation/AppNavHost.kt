package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                onOpenDetails = { navController.navigate(AppRoutes.APP_DETAILS) }
            )
        }
        composable(AppRoutes.APP_DETAILS) {
            AppDetailsScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}