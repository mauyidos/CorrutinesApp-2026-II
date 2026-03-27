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
import com.mauyidos.corrutinesapp_2026_ii.viewmodel.AccessViewModel
import com.mauyidos.corrutinesapp_2026_ii.viewmodel.TimeViewModel

@Composable
fun CoroutinesApp(timeVM: TimeViewModel, archiveVM: AccessViewModel, modifier: Modifier = Modifier) {
    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        /*
        Button(
            onClick = {changeColor = !changeColor},
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Cyan else Color.Blue
            )
        ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }

        Spacer(modifier = modifier.height(5.dp))

        Text(text = "${timeVM.countTimeSequential}/10 [s]")
        Button(
            onClick = {
                timeVM.counterSequential()
            }
        ) {
            Text(text = "Contador secuencial")
        }
        Button(
            onClick = {
                timeVM.counterSequential()
                timeVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 2N")
        }
        Button(
            onClick = {
                timeVM.counterSequential()
                for (i in 1..2)
                    timeVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 3N")
        }
        Button(
            onClick = {
                timeVM.counterSequential()
                for (i in 1..3)
                    timeVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 4N")
        }
        Button(
            onClick = {
                timeVM.counterSequential()
                for (i in 1..4)
                    timeVM.counterSequential(null)
            }
        ) {
            Text(text = "Contador secuencial 5N")
        }

        Spacer(modifier = modifier.height(5.dp))

        Text(text = "${timeVM.countTimeConcurrent}/10 [s]")
        Button(
            onClick = {
                timeVM.counterConcurrent(null)
            }
        ) {
            Text(text = "Contador concurrente")
        }

        Spacer(modifier = modifier.height(5.dp))

        Button(
            onClick = {
                timeVM.reset()
            }
        ) {
            Text(text = "Reset")
        }

        Spacer(modifier = modifier.height(5.dp))
         */

        Text(
            text = "Estado del archivo: ${archiveVM.resultState}\n${if (archiveVM.isArchiveOpen) "El archivo ha estado abierto por ${archiveVM.timer.countTimeConcurrent} [s]" else ""}"
        )
        Button(
            onClick = {
                archiveVM.OpenArchive()
            }
        ) {
            Text(text = "Abrir archivo")
        }
        Button(
            onClick = {
                archiveVM.CloseArchive()
            }
        ) {
            Text(text = "Cerrar archivo")
        }

    }
}