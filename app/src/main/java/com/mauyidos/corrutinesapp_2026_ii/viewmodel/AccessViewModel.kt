package com.mauyidos.corrutinesapp_2026_ii.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AccessViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var isArchiveOpen by mutableStateOf(false)
        private set

    val timer = TimeViewModel()

    fun OpenArchive() {
        if (!isArchiveOpen) {
            resultState = "Obteniendo datos del archivo"
            isArchiveOpen = true
            timer.CounterConcurrent(max = 10000, timeLapse = 1000)
        }
        else {
            resultState = "El archivo ya está abierto"
        }
    }

    fun CloseArchive() {
        if (isArchiveOpen) {
            resultState = "Cerrando archivo"
            isArchiveOpen = false
            timer.Reset()
        }
        else {
            resultState = "El archivo ya está cerrado"
        }
    }
}