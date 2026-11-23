package ru.mirea.todolist.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.mirea.todolist.domain.model.TodoItem
import ru.mirea.todolist.domain.repository.TodoRepository

class TodoUseCasesTest {
    @Test
    fun getTodosReturnsThreeTasks() = runBlocking {
        val useCase = GetTodosUseCase(FakeTodoRepository())
        assertEquals(3, useCase().size)
    }

    @Test
    fun toggleTodoChangesCompletionStatus() = runBlocking {
        val repository = FakeTodoRepository()
        ToggleTodoUseCase(repository)(1)
        assertTrue(repository.getTodos().first { it.id == 1 }.isCompleted)
    }
}

private class FakeTodoRepository : TodoRepository {
    private var todos = mutableListOf(
        TodoItem(1, "Купить молоко", "2 литра", false),
        TodoItem(2, "Позвонить маме", "Спросить про выходные", true),
        TodoItem(3, "Сделать ДЗ по Android", "Clean Architecture + Compose", false),
    )

    override suspend fun getTodos(): List<TodoItem> = todos.toList()

    override suspend fun toggleTodo(id: Int) {
        todos = todos.map { todo ->
            if (todo.id == id) todo.copy(isCompleted = !todo.isCompleted) else todo
        }.toMutableList()
    }
}

