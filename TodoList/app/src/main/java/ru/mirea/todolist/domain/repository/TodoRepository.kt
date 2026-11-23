package ru.mirea.todolist.domain.repository

import ru.mirea.todolist.domain.model.TodoItem

interface TodoRepository {
    suspend fun getTodos(): List<TodoItem>
    suspend fun toggleTodo(id: Int)
}

