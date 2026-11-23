package ru.mirea.todolist.data.model

import ru.mirea.todolist.domain.model.TodoItem

data class TodoItemDto(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
) {
    fun toDomain() = TodoItem(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
    )
}

