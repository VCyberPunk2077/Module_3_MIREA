package ru.mirea.todolist.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.mirea.todolist.data.local.TodoJsonDataSource
import ru.mirea.todolist.domain.model.TodoItem
import ru.mirea.todolist.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val dataSource: TodoJsonDataSource,
) : TodoRepository {
    private var cachedTodos: List<TodoItem>? = null

    override suspend fun getTodos(): List<TodoItem> {
        val current = cachedTodos ?: withContext(Dispatchers.IO) {
            dataSource.readTodos().map { it.toDomain() }
        }.also { cachedTodos = it }
        return current.toList()
    }

    override suspend fun toggleTodo(id: Int) {
        val current = getTodos()
        cachedTodos = current.map { todo ->
            if (todo.id == id) todo.copy(isCompleted = !todo.isCompleted) else todo
        }
    }
}

