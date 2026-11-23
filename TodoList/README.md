# TodoList

Учебное Android-приложение списка задач на Kotlin и Jetpack Compose. Архитектура разделена на слои Data, Domain и Presentation. Задачи читаются из JSON-файла в `assets`; приложение показывает список и детали, позволяет менять статус задачи.

## Запуск

Откройте каталог `TodoList` в Android Studio, дождитесь синхронизации Gradle и запустите конфигурацию `app` на эмуляторе или устройстве.

## Тесты

```bash
./gradlew testDebugUnitTest
./gradlew connectedDebugAndroidTest
```

Оба набора тестов прошли: 2 модульных теста и 3 Compose UI-теста на эмуляторе Android 15.
