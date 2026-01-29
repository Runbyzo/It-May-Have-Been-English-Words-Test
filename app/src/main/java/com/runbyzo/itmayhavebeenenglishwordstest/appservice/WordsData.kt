package com.runbyzo.itmayhavebeenenglishwordstest.appservice

// Translations.kt - Categorized version
object TranslationData {

    // All translations organized by category
    val allTranslations = arrayOf(
        // Greetings category
        arrayOf(
            Translation("hello", "привет"),
            Translation("goodbye", "до свидания"),
            Translation("good morning", "доброе утро"),
            Translation("good evening", "добрый вечер"),
            Translation("good night", "спокойной ночи")
        ),

        // Common phrases
        arrayOf(
            Translation("thank you", "спасибо"),
            Translation("please", "пожалуйста"),
            Translation("excuse me", "извините"),
            Translation("sorry", "простите"),
            Translation("you're welcome", "пожалуйста")
        ),

        // Questions
        arrayOf(
            Translation("what?", "что?"),
            Translation("where?", "где?"),
            Translation("when?", "когда?"),
            Translation("why?", "почему?"),
            Translation("how?", "как?")
        ),

        // Numbers (1-10)
        arrayOf(
            Translation("one", "один"),
            Translation("two", "два"),
            Translation("three", "три"),
            Translation("four", "четыре"),
            Translation("five", "пять"),
            Translation("six", "шесть"),
            Translation("seven", "семь"),
            Translation("eight", "восемь"),
            Translation("nine", "девять"),
            Translation("ten", "десять")
        )
    ).flatten() // Combine all arrays into one

    // Access all translations as a simple list
    val simpleTranslations = allTranslations

    data class Translation(
        val english: String,
        val russian: String
    )
}