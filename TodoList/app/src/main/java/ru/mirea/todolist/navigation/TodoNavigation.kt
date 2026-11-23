package ru.mirea.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.mirea.todolist.presentation.ui.screen.TodoDetailScreen
import ru.mirea.todolist.presentation.ui.screen.TodoListScreen
import ru.mirea.todolist.presentation.viewmodel.TodoUiState
import ru.mirea.todolist.presentation.viewmodel.TodoViewModel

@Composable
fun TodoNavigation(viewModel: TodoViewModel) {
    val navController = rememberNavController()
    val state by viewModel.uiState.collectAsState()
    val todos = (state as? TodoUiState.Content)?.todos.orEmpty()

    NavHost(navController = navController, startDestination = "todos") {
        composable("todos") {
            TodoListScreen(
                state = state,
                onToggle = viewModel::toggle,
                onOpen = { id -> navController.navigate("details/$id") },
            )
        }
        composable(
            route = "details/{todoId}",
            arguments = listOf(navArgument("todoId") { type = NavType.IntType }),
        ) { entry ->
            val todoId = entry.arguments?.getInt("todoId")
            val selectedTodo = todos.firstOrNull { it.id == todoId }
            TodoDetailScreen(
                todo = selectedTodo,
                onBack = { navController.popBackStack() },
            )
        }
    }
}

