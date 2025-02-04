package com.kobe.crudusers.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kobe.crudusers.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Whatsapp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WhatsApp",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                actions = {
                    IconButton(onClick = {
                        //nothing now
                    }) {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                            ,
                            painter = painterResource(R.drawable.camera_icn),
                            contentDescription = "camera"
                        )
                    }
                    IconButton(onClick = {
                        //nothing now
                    }) {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                            ,
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = ":"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // nothing now
                }
            ){
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                    ,
                    painter = painterResource(R.drawable.add_button_icn),
                    contentDescription = null
                )
            }
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        IconButton(onClick = {}) {
                            Icon(modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.add_button_icn),
                                contentDescription = null
                            )
                        }
                        Text(text = "Discussions", style = MaterialTheme.typography.labelMedium)
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        IconButton(onClick = {}) {
                            Icon(modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.status),
                                contentDescription = null
                            )
                        }
                        Text(text = "Actu", style = MaterialTheme.typography.labelMedium)
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        IconButton(onClick = {}) {
                            Icon(modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.people),
                                contentDescription = null
                            )
                        }
                        Text(text = "Communautes", style = MaterialTheme.typography.labelMedium)
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        IconButton(onClick = {}) {
                            Icon(modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.telephone_icn),
                                contentDescription = null
                            )
                        }
                        Text(text = "Appels", style = MaterialTheme.typography.labelMedium)
                    }
                }
            }
        }
    ) { paddindValues->
        LazyColumn(
            modifier = Modifier
                .padding(paddindValues)
                .fillMaxSize()
        ) {
            items(100){
                ContentRow()
            }
        }
    }

}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun WhatsappPrevvv() {
    Whatsapp()
    //ContentRow()
}

@Composable
fun ContentRow() {
    val nom = "Abdel Aziz"
    val date = "12-02-2025"
    val contentDep = "dalkjsd;flajkd;lfajksldjkfa;sdljkfa;sldjkfa;sdf"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
        ,

    ) {
        Image(
            contentDescription = null,
            imageVector = Icons.Filled.Person,
            modifier = Modifier.size(85.dp)
        )

        Column(
            modifier = Modifier.padding(10.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = nom)
                Text(text = date)
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier
                .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = contentDep,
                    maxLines = 1
                )
            }

        }
    }
}