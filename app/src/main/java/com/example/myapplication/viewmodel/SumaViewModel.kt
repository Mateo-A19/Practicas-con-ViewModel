package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SumaViewModel : ViewModel() {
    private val _numero1 = MutableStateFlow("")
    val numero1: StateFlow<String> = _numero1.asStateFlow()

    private val _numero2 = MutableStateFlow("")
    val numero2: StateFlow<String> = _numero2.asStateFlow()

    private val _resultado = MutableStateFlow("")
    val resultado: StateFlow<String> = _resultado.asStateFlow()

    fun onNumero1Change(value: String) {
        _numero1.value = value
    }

    fun onNumero2Change(value: String) {
        _numero2.value = value
    }

    fun sumar() {
        val num1 = _numero1.value.toDoubleOrNull() ?: 0.0
        val num2 = _numero2.value.toDoubleOrNull() ?: 0.0
        _resultado.value = (num1 + num2).toString()
    }
}
