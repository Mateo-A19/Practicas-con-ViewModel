package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TemperaturaViewModel : ViewModel() {
    private val _input = MutableStateFlow("")
    val input: StateFlow<String> = _input.asStateFlow()

    private val _resultado = MutableStateFlow("")
    val resultado: StateFlow<String> = _resultado.asStateFlow()

    fun onInputChange(value: String) {
        _input.value = value
    }

    fun convertirCelsiusAFahrenheit() {
        val celsius = _input.value.toDoubleOrNull()
        _resultado.value = if (celsius != null) {
            val fahrenheit = (celsius * 9 / 5) + 32
            String.format("%.2f°C = %.2f°F", celsius, fahrenheit)
        } else {
            "Ingresa un numero valido"
        }
    }

    fun convertirFahrenheitACelsius() {
        val fahrenheit = _input.value.toDoubleOrNull()
        _resultado.value = if (fahrenheit != null) {
            val celsius = (fahrenheit - 32) * 5 / 9
            String.format("%.2f°F = %.2f°C", fahrenheit, celsius)
        } else {
            "Ingresa un numero valido"
        }
    }

    fun limpiar() {
        _input.value = ""
        _resultado.value = ""
    }
}