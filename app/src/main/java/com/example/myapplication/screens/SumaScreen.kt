package com.example.myapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.viewmodel.SumaViewModel

@Composable
fun SumaScreen(sumaViewModel: SumaViewModel) {
    val numero1 by sumaViewModel.numero1.collectAsState()
    val numero2 by sumaViewModel.numero2.collectAsState()
    val resultado by sumaViewModel.resultado.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = numero1,
                onValueChange = { sumaViewModel.onNumero1Change(it) },
                label = { Text("Número 1") },
                singleLine = true,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            )

            TextField(
                value = numero2,
                onValueChange = { sumaViewModel.onNumero2Change(it) },
                label = { Text("Número 2") },
                singleLine = true,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            )

            Button(
                onClick = { sumaViewModel.sumar() },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Sumar")
            }

            if (resultado.isNotEmpty()) {
                Text(
                    text = "Resultado: $resultado",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}