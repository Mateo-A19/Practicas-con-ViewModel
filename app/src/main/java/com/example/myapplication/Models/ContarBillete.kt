package com.example.myapplication.models

class ContarBillete {
    private val listaBilletes = mutableListOf<CantidadBillete>()

    fun agregarBillete(cantidadBillete: CantidadBillete) {
        listaBilletes.add(cantidadBillete)
    }

    fun limpiarLista() {
        listaBilletes.clear()
    }

    fun calcularTotal(): Double {
        return listaBilletes.sumOf { it.cantidad * it.billete.valor }
    }

    fun obtenerLista(): List<CantidadBillete> {
        return listaBilletes.toList()
    }
}