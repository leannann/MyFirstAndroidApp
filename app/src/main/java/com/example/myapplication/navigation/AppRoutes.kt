package com.example.myapplication.navigation

object AppRoutes {
    const val APPS_LIST = "apps_list"

    const val APP_DETAILS = "app_details"
    const val ARG_APP_ID = "appId"

    const val APP_DETAILS_PATTERN = "$APP_DETAILS/{$ARG_APP_ID}"

    fun appDetails(appId: Int): String = "$APP_DETAILS/$appId"
}