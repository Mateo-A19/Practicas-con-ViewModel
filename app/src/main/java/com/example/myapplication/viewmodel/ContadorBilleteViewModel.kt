package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.ContarBillete
import com.example.myapplication.models.Billete
import com.example.myapplication.models.CantidadBillete
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadorBilletesViewModel : ViewModel() {

    private val listaContador = ContarBillete()

    val billetesDisponibles = listOf(
        Billete(1000.0, "Mil pesos"),
        Billete(500.0, "Quinientos pesos"),
        Billete(200.0, "Doscientos pesos"),
        Billete(100.0, "Cien pesos"),
        Billete(50.0, "Cincuenta pesos"),
        Billete(20.0, "Veinte pesos")
    )

    private val _cantidades = MutableStateFlow(
        billetesDisponibles.associate { it.valor to 0 }
    )
    val cantidades: StateFlow<Map<Double, Int>> = _cantidades.asStateFlow()

    private val _total = MutableStateFlow(0.0)
    val total: StateFlow<Double> = _total.asStateFlow()

    private val _listaBilletes = MutableStateFlow<List<CantidadBillete>>(emptyList())
    val listaBilletes: StateFlow<List<CantidadBillete>> = _listaBilletes.asStateFlow()

    fun incrementarCantidad(billete: Billete) {
        val cantidadActual = _cantidades.value[billete.valor] ?: 0
        _cantidades.value = _cantidades.value.toMutableMap().apply {
            put(billete.valor, cantidadActual + 1)
        }
        actualizarTotal()
    }

    fun decrementarCantidad(billete: Billete) {
        val cantidadActual = _cantidades.value[billete.valor] ?: 0
        if (cantidadActual > 0) {
            _cantidades.value = _cantidades.value.toMutableMap().apply {
                put(billete.valor, cantidadActual - 1)
            }
            actualizarTotal()
        }
    }

    fun setCantidad(billete: Billete, cantidad: String) {
        val nuevaCantidad = cantidad.toIntOrNull() ?: 0
        if (nuevaCantidad >= 0) {
            _cantidades.value = _cantidades.value.toMutableMap().apply {
                put(billete.valor, nuevaCantidad)
            }
            actualizarTotal()
        }
    }

    private fun actualizarTotal() {
        listaContador.limpiarLista()
        _cantidades.value.forEach { (valor, cantidad) ->
            if (cantidad > 0) {
                val billete = billetesDisponibles.find { it.valor == valor }
                if (billete != null) {
                    listaContador.agregarBillete(CantidadBillete(cantidad, billete))
                }
            }
        }
        _total.value = listaContador.calcularTotal()
        _listaBilletes.value = listaContador.obtenerLista()
    }

    fun limpiar() {
        _cantidades.value = billetesDisponibles.associate { it.valor to 0 }
        listaContador.limpiarLista()
        _total.value = 0.0
        _listaBilletes.value = emptyList()
    }
}