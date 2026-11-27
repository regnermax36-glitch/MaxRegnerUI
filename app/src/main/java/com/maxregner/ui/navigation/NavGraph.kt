package com.maxregner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxregner.ui.screens.*

object Routes {
    const val LOCK = "lock"
    const val HOME = "home"
    const val APP_DRAWER = "app_drawer"
    const val MEDIA = "media"
    const val QUICK_SETTINGS = "quick_settings"
    const val SETTINGS = "settings"
    const val CLOCK_FACES = "clock_faces"
    const val WIDGETS = "widgets"
}

@Composable
fun MaxRegnerNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.LOCK) {
            LockScreen(
                onUnlock = { navController.navigate(Routes.HOME) {
                    popUpTo(Routes.LOCK) { inclusive = true }
                }}
            )
        }
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDrawer = { navController.navigate(Routes.APP_DRAWER) },
                onOpenMedia = { navController.navigate(Routes.MEDIA) },
                onOpenQuickSettings = { navController.navigate(Routes.QUICK_SETTINGS) },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
                onOpenWidgets = { navController.navigate(Routes.WIDGETS) }
            )
        }
        composable(Routes.APP_DRAWER) {
            AppDrawerScreen(
                onBack = { navController.popBackStack() },
                onAppClick = { }
            )
        }
        composable(Routes.MEDIA) {
            MediaScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.QUICK_SETTINGS) {
            QuickSettingsScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.SETTINGS) {
            SettingsScreen(
                onBack = { navController.popBackStack() },
                onOpenClockFaces = { navController.navigate(Routes.CLOCK_FACES) }
            )
        }
        composable(Routes.CLOCK_FACES) {
            ClockFacesScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.WIDGETS) {
            WidgetsScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
