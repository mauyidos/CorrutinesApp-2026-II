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

    var countTime by mutableStateOf(0)
        private set

    var countTime2 by mutableStateOf(0)
        private set

    var terminaContador1 = false
    var terminaContadores = false

    fun fetchData() {
        resultState = "Obteniendo datos de la Web"
        countTime = 0

        // Sirve para procesos Composables en otro caso se utiliza job
        val jobContador1 = viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                if (terminaContador1 or terminaContadores) break
                countTime = i
                if (i == 5) {
                    terminaContador1 = true

                    resultState = "Respuesta obtenida de la Web"

                    val jobContador2 = viewModelScope.launch {
                        countTime2 = 0
                        delay(1000)
                        terminaContador1 = false
                        while (!terminaContadores) {
                            countTime2++
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