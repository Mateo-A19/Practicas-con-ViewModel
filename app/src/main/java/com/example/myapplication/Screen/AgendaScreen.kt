package com.example.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.PersonaViewModel

@Composable
fun AgendaScreen(
    modifier: Modifier = Modifier,
    vm: PersonaViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = vm.nombre.value,
            onValueChange = { vm.nombre.value = it },
            label = { Text("Ingrese nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = vm.edad.value,
            onValueChange = { vm.edad.value = it },
            label = { Text("Ingrese edad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = vm.telefono.value,
            onValueChange = { vm.telefono.value = it },
            label = { Text("Ingrese teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { vm.agregarPersona() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("AGREGAR PERSONA")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(vm.listaPersonas) { persona ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Nombre: ${persona.nombre}")
                        Text(text = "Edad: ${persona.edad}")
                        Text(text = "Teléfono: ${persona.telefono}")
                    }
                }
            }
        }
    }
}
