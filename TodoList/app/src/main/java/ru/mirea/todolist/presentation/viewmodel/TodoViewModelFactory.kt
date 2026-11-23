package ru.mirea.todolist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.mirea.todolist.domain.repository.TodoRepository
import ru.mirea.todolist.domain.usecase.GetTodosUseCase
import ru.mirea.todolist.domain.usecase.ToggleTodoUseCase

class TodoViewModelFactory(
    private val repository: TodoRepository,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            throw IllegalArgumentException("Unknown ViewModel: " + modelClass.name)
        }
        return TodoViewModel(
            getTodos = GetTodosUseCase(repository),
            toggleTodo = ToggleTodoUseCase(repository),
        ) as T
    }
}

