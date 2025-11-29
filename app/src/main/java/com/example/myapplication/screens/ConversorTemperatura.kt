package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.TemperaturaViewModel

@Composable
fun ConversorTemperatura(viewModel: TemperaturaViewModel = viewModel()) {
    val input by viewModel.input.collectAsState()
    val resultado by viewModel.resultado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Conversor de Temperatura",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TextField(
            value = input,
            onValueChange = { viewModel.onInputChange(it) },
            label = { Text("Ingresa la temperatura") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Button(
            onClick = { viewModel.convertirCelsiusAFahrenheit() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Celsius → Fahrenheit")
        }

        Button(
            onClick = { viewModel.convertirFahrenheitACelsius() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Fahrenheit → Celsius")
        }

        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        OutlinedButton(
            onClick = { viewModel.limpiar() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpiar")
        }
    }
}