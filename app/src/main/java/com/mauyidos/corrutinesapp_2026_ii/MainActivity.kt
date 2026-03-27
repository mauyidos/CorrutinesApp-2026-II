package com.mauyidos.corrutinesapp_2026_ii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mauyidos.corrutinesapp_2026_ii.ui.CoroutinesApp
import com.mauyidos.corrutinesapp_2026_ii.ui.theme.CorrutinesApp2026IITheme
import com.mauyidos.corrutinesapp_2026_ii.viewmodel.AccessViewModel
import com.mauyidos.corrutinesapp_2026_ii.viewmodel.TimeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CorrutinesApp2026IITheme {
                val viewModel = TimeViewModel()
                val archiveModel = AccessViewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoroutinesApp(
                        viewModel,
                        archiveModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CorrutinesApp2026IITheme(darkTheme = false) {
        CoroutinesApp(
            TimeViewModel()
        )
    }
}
 */