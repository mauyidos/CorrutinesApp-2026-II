package com.mauyidos.corrutinesapp_2026_ii.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mauyidos.corrutinesapp_2026_ii.R
import com.mauyidos.corrutinesapp_2026_ii.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(mainVM: MainViewModel, modifier: Modifier = Modifier) {
    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {changeColor = !changeColor},
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Cyan else Color.Blue
            )
        ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }

        Spacer(modifier = modifier.height(15.dp))

        Text(text = "${mainVM.countTimeSequential}/10 [s]")
        Button(
            onClick = {
                mainVM.counterSequential()
            }
        ) {
            Text(text = "Contador secuencial")
        }
        Button(
            onClick = {
                mainVM.counterSequential()
                mainVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 2N")
        }
        Button(
            onClick = {
                mainVM.counterSequential()
                for (i in 1..2)
                    mainVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 3N")
        }
        Button(
            onClick = {
                mainVM.counterSequential()
                for (i in 1..3)
                    mainVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 4N")
        }
        Button(
            onClick = {
                mainVM.counterSequential()
                for (i in 1..4)
                    mainVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 5N")
        }

        Spacer(modifier = modifier.height(15.dp))

        Text(text = "${mainVM.countTimeConcurrent}/10 [s]")
        Button(
            onClick = {
                mainVM.counterConcurrent(null)
            }
        ) {
            Text(text = "Contador concurrente")
        }

        Spacer(modifier = modifier.height(15.dp))

        Button(
            onClick = {
                mainVM.reset()
            }
        ) {
            Text(text = "Reset")
        }
    }
}