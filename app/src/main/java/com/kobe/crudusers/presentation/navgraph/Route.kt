package com.kobe.crudusers.presentation.navgraph

sealed class Route(val route: String) {
    object HomeScreen: Route(route = "home_screen")
    object SaveScreen: Route(route = "save_screen")
    object GetScreen: Route(route = "get_screen")
}