package com.runbyzo.itmayhavebeenenglishwordstest.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.runbyzo.itmayhavebeenenglishwordstest.appservice.TranslationData.allTranslations
import com.runbyzo.itmayhavebeenenglishwordstest.appservice.getRandomWord

@Composable
fun TestPage(navController: NavController) {

    val testWords = remember {
        mutableListOf(
            getRandomWord(allTranslations),
            getRandomWord(allTranslations),
            getRandomWord(allTranslations)
        )
    }

    val correctWord = testWords.random()
    val question = correctWord.english
    val answers = testWords.shuffled().map { it.russian }

    fun onAnswerClick(selected: String) {
        if (selected == correctWord.russian) {
            // open next question
            navController.navigate("test page") {
                popUpTo("test page") { inclusive = true }
            }
        } else {
            // first mistake → back to main page
            navController.navigate("main page") {
                popUpTo("test page") { inclusive = true }
            }
        }
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            QuestionLabel(question)

            AnswerButtons(
                answ1 = answers[0],
                answ2 = answers[1],
                answ3 = answers[2],
                onAnswerClick = ::onAnswerClick
            )
        }
    }
}


@Composable
fun QuestionLabel(question: String){
    Column (
        modifier = Modifier
            .padding(10.dp)
    ){
        Text(
            text = question,
            fontSize = 70.sp
        )
    }
}

@Composable
fun AnswerButtons(
    answ1: String,
    answ2: String,
    answ3: String,
    onAnswerClick: (String) -> Unit
) {
    Column {
        listOf(answ1, answ2, answ3).forEach { answer ->
            OutlinedButton(
                onClick = { onAnswerClick(answer) },
                modifier = Modifier
                    .width(350.dp)
                    .height(100.dp)
                    .padding(10.dp),
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(answer, color = Color.Black)
            }
        }
    }
}
