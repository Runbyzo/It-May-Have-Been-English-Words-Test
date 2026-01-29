package com.runbyzo.itmayhavebeenenglishwordstest.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainPage(navController: NavController){
    Scaffold(
        content = { padding: PaddingValues ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                TitleText(
                    text = "English words quiz",
                    modifier = Modifier.padding(5.dp)
                )

                StartButton(
                    name = "start test",
                    modifier = Modifier
                        .padding(40.dp)
                        .size(200.dp),
                    onRegisterClick = {navController.navigate("test page")}
                )
            }

        }
    )
}


@Composable
fun TitleText(text: String,
              modifier: Modifier = Modifier,
              descModifier: Modifier = Modifier)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            modifier = modifier,
            fontSize = 100.sp,
        )
    }
}

@Composable
fun StartButton(name: String, modifier: Modifier, onRegisterClick: () -> Unit){
    OutlinedButton(
        onClick = {
            onRegisterClick()
        },
        modifier = modifier
    ) { Text(text = name, color = Color.Black) }
}