package com.example.myapplication.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.Models.Persona

class PersonaViewModel : ViewModel() {

    var nombre = mutableStateOf("")
    var edad = mutableStateOf("")
    var telefono = mutableStateOf("")
    var listaPersonas = mutableStateListOf<Persona>()

    fun agregarPersona() {
        val edadInt = edad.value.toIntOrNull() ?: 0 // Conversión segura
        listaPersonas.add(Persona(nombre.value, edadInt, telefono.value))
        nombre.value = ""
        edad.value = ""
        telefono.value = ""
    }
}