package com.example.jc_p3_v2.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jc_p3_v2.viewmodels.SendDataViewModel
import kotlinx.coroutines.launch

@Composable
fun SendDataScreen(
    navController: NavController,
    viewModel: SendDataViewModel = viewModel()
) {
    var textData by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //POLE DO WPROWADZANIA DANYCH
        TextField(
            value = textData,
            onValueChange = { textData = it },
            label = { Text("Wprowadź dane") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        //PRZYCISK WYSYŁANIA
        Button(
            onClick = {
                scope.launch {
                    val data = mapOf("text" to textData)
                    val result = viewModel.sendData(data)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Wyślij dane")
        }
        //odczytanie danych
        Button(
            onClick = {navController.navigate("read")


            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("odczytaj dane")
        }
    }
}