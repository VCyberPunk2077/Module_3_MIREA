package ru.mirea.module3kotlin.presentation.feed

import ru.mirea.module3kotlin.R

object ProfileRepository {
    val profiles = listOf(
        Profile(1, "Kotlin без страха", "Короткие заметки о типах, функциях и выразительном синтаксисе.", R.drawable.feed_kotlin),
        Profile(2, "Чистая архитектура", "Как разделить приложение на data, domain и presentation.", R.drawable.feed_architecture),
        Profile(3, "Compose на практике", "Собираем интерфейсы из небольших переиспользуемых компонентов.", R.drawable.feed_compose),
        Profile(4, "Проверяем поведение", "Покрываем важные сценарии тестами и ловим ошибки раньше.", R.drawable.feed_testing),
    )
}

