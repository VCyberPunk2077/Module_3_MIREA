package ru.mirea.todolist.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.mirea.todolist.domain.model.TodoItem
import ru.mirea.todolist.presentation.ui.component.TodoRow
import ru.mirea.todolist.presentation.viewmodel.TodoUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(
    state: TodoUiState,
    onToggle: (Int) -> Unit,
    onOpen: (Int) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Мои задачи")
                        Text(
                            text = "План на сегодня",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        when (state) {
            TodoUiState.Loading -> Text(
                text = "Загружаем задачи…",
                modifier = Modifier.padding(innerPadding).padding(24.dp),
            )
            is TodoUiState.Error -> Text(
                text = state.message,
                modifier = Modifier.padding(innerPadding).padding(24.dp),
            )
            is TodoUiState.Content -> TodoItems(
                todos = state.todos,
                modifier = Modifier.padding(innerPadding),
                onToggle = onToggle,
                onOpen = onOpen,
            )
        }
    }
}

@Composable
private fun TodoItems(
    todos: List<TodoItem>,
    modifier: Modifier = Modifier,
    onToggle: (Int) -> Unit,
    onOpen: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        item {
            Text(
                text = "Список задач",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
            )
        }
        items(todos, key = TodoItem::id) { todo ->
            TodoRow(
                todo = todo,
                onToggle = { onToggle(todo.id) },
                onOpen = { onOpen(todo.id) },
            )
        }
    }
}

