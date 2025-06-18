package com.example.appquanlythoigian


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appquanlythoigian.Screen.Screen1_Start
import com.example.appquanlythoigian.Screen.Screen2_End
import com.example.appquanlythoigian.Screen.Screen3_ThemViec

@Composable
fun JetpackComposeApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Start"
    ){
        composable("Start"){
            Screen1_Start(navController)
        }
        composable("End/{minutes}/{seconds}",
                arguments = listOf(
                navArgument("minutes") { type = NavType.IntType },
                navArgument("seconds") { type = NavType.IntType }
                )
        )
        {
            backStackEntry ->
            val minutes = backStackEntry.arguments?.getInt("minutes") ?: 0
            val seconds = backStackEntry.arguments?.getInt("seconds") ?: 0
            Screen2_End(navController, minutes, seconds)
        }
        composable("Viec"){
            Screen3_ThemViec(navController)
        }
    }
}