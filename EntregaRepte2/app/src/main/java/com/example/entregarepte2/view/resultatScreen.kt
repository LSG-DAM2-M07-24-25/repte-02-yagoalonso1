package com.example.entregarepte2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.entregarepte2.viewmodel.LaunchViewModel

@Composable
fun ResultatScreen(
    viewModel: LaunchViewModel,
    onRestart: () -> Unit
) {
    val selectedImage = viewModel.selectedImage.collectAsState().value
    val personatgee = viewModel.userName.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        selectedImage?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Hola, $personatgee",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { onRestart() }) {
            Text("Tornar")
        }
    }
}