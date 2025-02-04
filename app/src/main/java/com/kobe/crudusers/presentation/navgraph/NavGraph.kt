package com.kobe.crudusers.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kobe.crudusers.presentation.view.*
import com.kobe.crudusers.presentation.view.SharedViewModel


@Composable
fun NavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Route.HomeScreen.route
    ){
        composable(route = Route.HomeScreen.route){
            HomeScreen(
                navController = navController
            )
        }

        composable(route = Route.SaveScreen.route){
            SaveDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }

        composable(route = Route.GetScreen.route){
            GetDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }

    }
}