package com.example.wahtsappclone.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.auth.ui.mainauth.screen.MainAuthScreen
import com.example.auth.ui.otp.screen.OTPScreen
import com.example.auth.ui.viewmodel.AuthViewModel

private const val TransitionDuration = 600

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String,
) {
    
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(TransitionDuration)
            )
        },
        exitTransition = { fadeOut(tween(TransitionDuration)) },
        popEnterTransition = { fadeIn(tween(TransitionDuration)) },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(TransitionDuration)
            )
        }
    ) {
        composable(route = NavigationRoutes.MAIN_AUTH_SCREEN) {
            MainAuthScreen(navController = navController)
        }
        composable(route = NavigationRoutes.OTP_SCREEN) {
            OTPScreen()
        }
    }
}