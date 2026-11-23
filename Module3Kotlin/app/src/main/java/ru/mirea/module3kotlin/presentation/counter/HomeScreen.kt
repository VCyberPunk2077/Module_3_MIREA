package ru.mirea.module3kotlin.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdaptiveHomeScreen(
    widthSizeClass: WindowWidthSizeClass,
    count: Int,
    onIncrement: () -> Unit,
    onOpenDetails: () -> Unit,
) {
    when (widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                CounterPanel(count, onIncrement)
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(onClick = onOpenDetails) { Text("Открыть Details") }
            }
        }
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            Row(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CounterPanel(count, onIncrement, Modifier.weight(0.9f))
                DetailsPanel(Modifier.weight(1.1f), onOpenDetails)
            }
        }
        else -> {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                CounterPanel(count, onIncrement)
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(onClick = onOpenDetails) { Text("Открыть Details") }
            }
        }
    }
}

@Composable
private fun CounterPanel(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Счётчик", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = count.toString(),
                fontSize = 56.sp,
                lineHeight = 64.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onIncrement) { Text("Увеличить") }
        }
    }
}

@Composable
private fun DetailsPanel(
    modifier: Modifier = Modifier,
    onOpenDetails: () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Адаптивный экран",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "На широком экране счётчик и подробности находятся рядом. "
                    + "На телефоне приложение показывает одну колонку.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Spacer(modifier = Modifier.height(18.dp))
            Button(onClick = onOpenDetails) { Text("Перейти к Details") }
        }
    }
}

@Composable
fun DetailsScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Details", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Значение счётчика хранится во ViewModel и остаётся прежним после поворота экрана.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBack) { Text("Назад") }
    }
}

