# Модуль 3 Kotlin — проекты Android

В репозитории размещены два самостоятельных учебных проекта на Kotlin и Jetpack Compose.

## Module3Kotlin

Лента профилей, собственная Material-тема, журналирование жизненного цикла Activity, счётчик с состоянием во ViewModel, навигация и адаптивная компоновка для широкого окна.

Откройте каталог `Module3Kotlin` в Android Studio и запустите конфигурацию `app`. Сборка из командной строки: `./gradlew assembleDebug`.

## TodoList

Список задач с разделением на Data, Domain и Presentation, чтением данных из JSON и экраном деталей. В проект включены модульные и Compose UI-тесты.

Откройте каталог `TodoList` в Android Studio. Команды для тестирования:

```bash
./gradlew testDebugUnitTest
./gradlew connectedDebugAndroidTest
```

Последний проверенный прогон прошёл успешно: 2 модульных и 3 Compose UI-теста на эмуляторе Android 15.
