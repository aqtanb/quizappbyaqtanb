package com.aktanberdi.littlequiz

object Constants {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question (1, "Что такое Selfie Stick?", R.drawable.selfie,
        "Колбасорезка", "Штука для укладки волос", "Палка для селфи", "Очки для чтения", 3)
        questionsList.add(que1)

        val que2 = Question (2, "Кто изобрел Передвижной туалет?", R.drawable.tualet,
            "Томас Кранц", "Крис Гриффин", "Карл Разерфорд", "Джордж Генкис", 1)
        questionsList.add(que2)

        val que3 = Question (3, "Какое изобретение называется Слоновий стул?", R.drawable.slon,
            "Мягкий стул в виде слона", "Каменный стул для королей", "Стул с подушкой для спины", "Кресло с ножками в виде слонов", 3)
        questionsList.add(que3)

        val que4 = Question (4, "Что такое Hug Me Jacket?", R.drawable.hugme,
            "Куртка с втроенной системой обогрева", "Куртка с автоматическим сжатием при объятии", "Куртка, предназначенная для обнимания", "Куртка с втроенным фонариком", 3)
        questionsList.add(que4)

        val que5 = Question (5, "Какое странное изобретение создал Джошуа Шоу?", R.drawable.djosh,
            "Съедобные носки", "Автоматический лупоглаз", "Шапка для мобильного телефона", "Гитара на колесах", 1)
        questionsList.add(que5)

        val que6 = Question (6, "Что такое Baby Mop?", R.drawable.baby,
            "Устройства для мойки детей", "Детский комбинезон-швабра", "Автоматическое качельное кресло для младенцев", "Мобильный карман для пеленок", 2)
        questionsList.add(que6)

        val que7 = Question (7, "Какой изобретатель предложил Подушку для одиноких?", R.drawable.podushka,
            "Джон Джеймс", "Лонни Джонс", "Джек Льюис", "Кеннет Грум", 2)
        questionsList.add(que7)

        val que8 = Question (8, "Что такое Шапка-телевизор?", R.drawable.shapka,
            "Шапка с втроенным телевизором", "Костюм для детей в виде телевизора", "Карманный телевизор", "Автоматический пульт для телевизора", 1)
        questionsList.add(que8)

        return questionsList
    }
}