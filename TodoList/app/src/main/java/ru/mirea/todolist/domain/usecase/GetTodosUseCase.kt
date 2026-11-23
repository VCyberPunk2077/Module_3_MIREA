package ru.mirea.todolist.domain.usecase

import ru.mirea.todolist.domain.model.TodoItem
import ru.mirea.todolist.domain.repository.TodoRepository

class GetTodosUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(): List<TodoItem> = repository.getTodos()
}

