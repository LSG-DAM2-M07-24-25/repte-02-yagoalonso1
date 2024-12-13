package com.example.entregarepte2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.entregarepte2.viewmodel.LaunchViewModel
import com.example.entregarepte2.R

@Composable
fun PersonatgeScreen(
    viewModel: LaunchViewModel,
    onCharacterSelected: (Int) -> Unit,
    onContinue: () -> Unit
) {
    val selectedImage = viewModel.selectedImage.collectAsState().value

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
                .size(300.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                listOf(R.drawable.gomah, R.drawable.goku, R.drawable.vegeta).forEach { imageResId ->
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clickable { onCharacterSelected(imageResId) }
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                listOf(R.drawable.piccolo, R.drawable.supreme, R.drawable.masked_majin).forEach { imageResId ->
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clickable { onCharacterSelected(imageResId) }
                    )
                }
            }
        }

        Button(
            onClick = { onContinue() },
            enabled = selectedImage != null,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.Black
            ),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)
        ) {
            Text("Continuar")
        }
    }
}