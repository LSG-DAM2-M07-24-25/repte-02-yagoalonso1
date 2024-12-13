package com.example.entregarepte2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.entregarepte2.R
import com.example.entregarepte2.viewmodel.LaunchViewModel

@Composable
fun NomScreen(
    viewModel: LaunchViewModel,
    onNameEntered: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nom del personatge") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onNameEntered(name) },
            enabled = name.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.Black
            ),
        ) {
            Text("Continuar")
        }
    }
}