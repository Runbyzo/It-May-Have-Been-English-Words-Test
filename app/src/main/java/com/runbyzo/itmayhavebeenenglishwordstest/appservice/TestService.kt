package com.runbyzo.itmayhavebeenenglishwordstest.appservice

fun getRandomWord(collection: Iterable<TranslationData.Translation>): TranslationData.Translation {
    return collection.shuffled().random()
}