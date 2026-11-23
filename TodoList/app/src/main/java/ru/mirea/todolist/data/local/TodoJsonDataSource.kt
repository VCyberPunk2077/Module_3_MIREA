package ru.mirea.todolist.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.mirea.todolist.data.model.TodoItemDto

class TodoJsonDataSource(context: Context) {
    private val appContext = context.applicationContext
    private val gson = Gson()

    fun readTodos(): List<TodoItemDto> {
        val json = appContext.assets.open("todos.json")
            .bufferedReader()
            .use { it.readText() }
        val listType = object : TypeToken<List<TodoItemDto>>() {}.type
        return gson.fromJson(json, listType)
    }
}

