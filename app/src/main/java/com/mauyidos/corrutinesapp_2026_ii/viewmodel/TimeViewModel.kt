package com.mauyidos.corrutinesapp_2026_ii.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimeViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var countTimeSequential by mutableStateOf(0)
        private set

    var countTimeConcurrent by mutableStateOf(0)
        private set

    var reset by mutableStateOf(false)
        public set

    fun counterSequential(initialTime: Int? = 0) {
        if (initialTime != null) {
            reset = false
            countTimeSequential = initialTime
        }
        for (i in 1..5) {
            Thread.sleep(100)
            countTimeSequential++
        }
    }

    fun counterConcurrent(initialTime: Int? = 0, max: Int = 5, timeLapse: Long = 100) {
        if (initialTime != null) {
            reset = false
            countTimeSequential = initialTime
        }
        val jobConcurrentCounter = viewModelScope.launch {
            for (i in 1..max) {
                delay(timeLapse)
                countTimeConcurrent++
                if (reset) {
                    break
                }
            }
        }
        if (reset) {
            jobConcurrentCounter.cancel()
        }
    }

    fun reset() {
        countTimeSequential = 0
        countTimeConcurrent = 0
        reset = true
    }
}