package ru.mirea.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import ru.mirea.todolist.data.local.TodoJsonDataSource
import ru.mirea.todolist.data.repository.TodoRepositoryImpl
import ru.mirea.todolist.domain.repository.TodoRepository
import ru.mirea.todolist.navigation.TodoNavigation
import ru.mirea.todolist.presentation.viewmodel.TodoViewModel
import ru.mirea.todolist.presentation.viewmodel.TodoViewModelFactory
import ru.mirea.todolist.ui.theme.TodoListTheme

class MainActivity : ComponentActivity() {
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository: TodoRepository = TodoRepositoryImpl(
            TodoJsonDataSource(applicationContext),
        )
        todoViewModel = ViewModelProvider(
            this,
            TodoViewModelFactory(repository),
        )[TodoViewModel::class.java]

        setContent {
            TodoListTheme {
                TodoNavigation(viewModel = todoViewModel)
            }
        }
    }
}

