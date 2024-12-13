package com.example.entregarepte2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.entregarepte2.view.NomScreen
import com.example.entregarepte2.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("launch") }
    val viewModel = remember { launchmodelview() }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                "launch" -> LaunchScreen(
                    onLaunchComplete = { currentScreen = "personatge" }
                )

                "personatge" -> PersonatgeScreen(
                    viewModel = viewModel,
                    onCharacterSelected = { selectedImage ->
                        viewModel.selectImage(selectedImage)
                        currentScreen = "nom"
                    },
                    onContinue = { currentScreen = "nom" }
                )

                "nom" -> NomScreen(
                    viewModel = viewModel,
                    onNameEntered = { name ->
                        viewModel.setUserName(name)
                        currentScreen = "resultat"
                    }
                )

                "resultat" -> ResultatScreen(
                    viewModel = viewModel,
                    onRestart = { currentScreen = "personatge" }
                )
            }
        }
    }
}