package com.kobe.crudusers.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kobe.crudusers.data.datasource.UserData
import com.kobe.crudusers.presentation.navgraph.Route


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDataScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Get Data") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Route.HomeScreen.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
            )
        },

        ) { paddingValues ->

        var userId by remember { mutableStateOf("") }
        var userName by remember { mutableStateOf("") }
        var userProfession by remember { mutableStateOf("") }
        var userAge by remember { mutableStateOf("") }
        var ageInt by remember { mutableStateOf(0) }
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                value = userId,
                onValueChange = {userId = it},
                label = { Text("Enter User Id") },
                placeholder = { Text("User Id") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                trailingIcon = {
                    IconButton(onClick = {
                        sharedViewModel.getData(
                            userId = userId,
                            context = context,
                        ){data ->
                            userName = data.name
                            userProfession = data.profession
                            userAge = data.age.toString()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null
                        )
                    }
                },
            )

            Spacer(modifier = Modifier.height(100.dp))
            OutlinedTextField(
                value = userName,
                onValueChange = {userName = it},
                label = { Text("Enter User Name") },
                placeholder = { Text("User Name") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            OutlinedTextField(
                value = userProfession,
                onValueChange = {userProfession = it},
                label = { Text("Enter User Profession") },
                placeholder = { Text("User Profession") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            OutlinedTextField(
                value = userAge,
                onValueChange = {
                    userAge = it
                    ageInt = userAge.toInt()
                },
                label = { Text("Enter User Age") },
                placeholder = { Text("User Age") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            )
            {
                Button(
                    onClick = {
                        val user = UserData(
                            userId = userId,
                            name = userName,
                            profession = userProfession,
                            age = ageInt
                        )
                        sharedViewModel.saveData(
                            userData = user,
                            context = context
                        )
                    }, modifier = Modifier.fillMaxWidth(0.50f)
                ){
                    Text(text = "Save")
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {
                        sharedViewModel.deleteData(
                            userId = userId,
                            context = context,
                            navController = navController
                        )
                    }, modifier = Modifier.fillMaxWidth(0.50f)
                ){
                    Text(text = "Delete")
                }
            }

        }
    }

}