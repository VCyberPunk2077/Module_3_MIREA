package ru.mirea.todolist.domain.usecase

import ru.mirea.todolist.domain.repository.TodoRepository

class ToggleTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(id: Int) = repository.toggleTodo(id)
}

