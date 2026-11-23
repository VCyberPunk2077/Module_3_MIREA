package ru.mirea.todolist.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.mirea.todolist.domain.model.TodoItem

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TodoDetailScreen(
    todo: TodoItem?,
    onBack: () -> Unit,
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Детали задачи") }) },
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            if (todo == null) {
                Text("Задача не найдена", style = MaterialTheme.typography.titleLarge)
            } else {
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Column(modifier = Modifier.padding(22.dp)) {
                        Text(todo.title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(todo.description, style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            text = if (todo.isCompleted) "Статус: выполнена" else "Статус: не выполнена",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onBack) { Text("К списку") }
        }
    }
}

