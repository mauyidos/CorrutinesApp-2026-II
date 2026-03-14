package com.mauyidos.corrutinesapp_2026_ii.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mauyidos.corrutinesapp_2026_ii.R
import com.mauyidos.corrutinesapp_2026_ii.ui.theme.CorrutinesApp2026IITheme
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

        Spacer(modifier = modifier.height(30.dp))

        Text(text = "${mainVM.countTime} [s]")

        Spacer(modifier = modifier.height(30.dp))

        Text(text = mainVM.resultState)

        Spacer(modifier = modifier.height(30.dp))

        Button(
            onClick = {
                mainVM.fetchData()
                //mainVM.bloqueoApp()
            }
        ) {
            Text(text = stringResource(R.string.realizar_consulta))
        }

        Spacer(modifier = modifier.height(30.dp))

        Text(text = "Tiempo desde la última consulta ${mainVM.countTime2} [s]")

        Spacer(modifier = modifier.height(30.dp))

        Button(
            onClick = {
                mainVM.terminaContadores = true
            }
        ) {
            Text(text = stringResource(R.string.detener_contadores))
        }
    }
}