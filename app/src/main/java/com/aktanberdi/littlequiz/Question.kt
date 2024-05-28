package com.aktanberdi.littlequiz

data class Question(
    val id : Int,
    val question : String,
    val ivImage : Int,
    val firstOpt : String,
    val secondOpt : String,
    val thirdOpt : String,
    val fourthOpt : String,
    val correctAnswer : Int
)
