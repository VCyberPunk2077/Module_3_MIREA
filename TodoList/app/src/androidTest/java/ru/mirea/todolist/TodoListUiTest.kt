package ru.mirea.todolist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TodoListUiTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun listDisplaysAllThreeTasksFromJson() {
        composeRule.onNodeWithText("Купить молоко").assertIsDisplayed()
        composeRule.onNodeWithText("Позвонить маме").assertIsDisplayed()
        composeRule.onNodeWithText("Сделать ДЗ по Android").assertIsDisplayed()
    }

    @Test
    fun checkboxChangesTaskStatus() {
        composeRule.onNodeWithTag("todo_checkbox_1").assertIsOff()
        composeRule.onNodeWithTag("todo_checkbox_1").performClick()
        composeRule.onNodeWithTag("todo_checkbox_1").assertIsOn()
    }

    @Test
    fun navigationOpensDetailsAndReturnsToList() {
        composeRule.onNodeWithTag("todo_card_1").performClick()
        composeRule.onNodeWithText("2 литра, обезжиренное").assertIsDisplayed()
        composeRule.onNodeWithText("К списку").performClick()
        composeRule.onNodeWithText("Список задач").assertIsDisplayed()
    }
}

