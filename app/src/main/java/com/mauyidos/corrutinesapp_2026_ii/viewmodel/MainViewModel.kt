package com.mauyidos.corrutinesapp_2026_ii.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var countTimeSequential by mutableStateOf(0)
        private set

    var countTimeConcurrent by mutableStateOf(0)
        private set

    var terminaContador1 = false
    var terminaContadores = false

    fun counterSequential(initialTime: Int? = 0) {
        if (initialTime != null) {
            countTimeSequential = initialTime
        }
        for (i in 1..5) {
            Thread.sleep(100)
            countTimeSequential++
        }
    }

    fun counterConcurrent(initialTime: Int? = 0) {
        if (initialTime != null) {
            countTimeSequential = initialTime
        }
        val jobConcurrentCounter = viewModelScope.launch {
            for (i in 1..5) {
                delay(100)
                countTimeConcurrent++
            }
        }
    }

    fun reset() {
        countTimeSequential = 0
        countTimeConcurrent = 0
    }

    fun fetchData() {
        resultState = "Obteniendo datos de la Web"
        countTimeSequential = 0

        // Sirve para procesos Composables en otro caso se utiliza job
        val jobContador1 = viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                if (terminaContador1 or terminaContadores) break
                countTimeSequential = i
                if (i == 5) {
                    terminaContador1 = true

                    resultState = "Respuesta obtenida de la Web"

                    val jobContador2 = viewModelScope.launch {
                        countTimeConcurrent = 0
                        delay(1000)
                        terminaContador1 = false
                        while (!terminaContadores) {
                            countTimeConcurrent++
                            delay(1000)
                            if (terminaContador1) {
                                terminaContador1 = false
                                break
                            }
                        }
                    }

                    //jobContador2.cancel()
                }
            }
        }

        val jobCancelJobs = viewModelScope.launch {
            while (!terminaContadores) {
                delay(100)
                if (terminaContadores) {
                    jobContador1.cancel()
                }
            }
        }

        if (terminaContadores) {
            jobCancelJobs.cancel()
            terminaContador1 = false
            terminaContadores = false
        }
    }

    /*
    // Proceso sincrono
    fun bloqueoApp() {
        Thread.sleep(5000)
        resultState = "Respuesta obtenida de la Web"
    }
    */
}