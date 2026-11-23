package ru.mirea.todolist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mirea.todolist.domain.model.TodoItem
import ru.mirea.todolist.domain.usecase.GetTodosUseCase
import ru.mirea.todolist.domain.usecase.ToggleTodoUseCase

sealed interface TodoUiState {
    data object Loading : TodoUiState
    data class Content(val todos: List<TodoItem>) : TodoUiState
    data class Error(val message: String) : TodoUiState
}

class TodoViewModel(
    private val getTodos: GetTodosUseCase,
    private val toggleTodo: ToggleTodoUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<TodoUiState>(TodoUiState.Loading)
    val uiState: StateFlow<TodoUiState> = _uiState.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            runCatching { getTodos() }
                .onSuccess { _uiState.value = TodoUiState.Content(it) }
                .onFailure { _uiState.value = TodoUiState.Error("Не удалось загрузить задачи") }
        }
    }

    fun toggle(id: Int) {
        viewModelScope.launch {
            runCatching {
                toggleTodo(id)
                getTodos()
            }.onSuccess {
                _uiState.value = TodoUiState.Content(it)
            }.onFailure {
                _uiState.value = TodoUiState.Error("Не удалось изменить задачу")
            }
        }
    }
}

