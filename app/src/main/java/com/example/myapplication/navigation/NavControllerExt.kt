package com.example.myapplication.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateToDetails(appId: Int) {
    navigate(AppRoutes.appDetails(appId))
}

fun NavHostController.navigateBack() {
    popBackStack()
}