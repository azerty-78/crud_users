package com.kobe.crudusers.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kobe.crudusers.presentation.navgraph.Route

@Composable
fun HomeScreen(
    navController: NavController
) {
    //Whatsapp()

    Column(
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
            navController.navigate(route = Route.GetScreen.route)
        }) {
            Text(text = "Get User")
        }
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {navController.navigate(Route.SaveScreen.route)}
        ) {
            Text(text = "Add User")
        }
    }

}

@Composable
fun ShowOut() {
    Column(
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                //navController.navigate(route = Route.GetScreen.route)
            }) {
            Text(text = "Get User")
        }
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {//navController.navigate(Route.SaveScreen.route)
            }
        ) {
            Text(text = "Add User")
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ShowOutPrevv() {
    ShowOut()
}