package com.example.jc_p3_v2.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jc_p3_v2.viewmodels.ReadDataViewModel

@Composable
fun ReadDataScreen(
    navController: NavController,
    viewModel: ReadDataViewModel = viewModel()
) {
    val dataList by viewModel.dataList.collectAsState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // WYŚWIETLANIE LISTY POBRANYCH DANYCH
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(dataList) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }

        // PRZYCISK POWROTU
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(top = 16.dp) // Odstęp od listy
                .fillMaxWidth()
        ) {
            Text("Powrót")
        }
    }
}

