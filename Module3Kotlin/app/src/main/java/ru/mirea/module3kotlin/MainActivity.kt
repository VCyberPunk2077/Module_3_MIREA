package ru.mirea.module3kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import ru.mirea.module3kotlin.navigation.AppNavigation
import ru.mirea.module3kotlin.presentation.counter.CounterViewModel
import ru.mirea.module3kotlin.ui.theme.Module3Theme

@OptIn(кExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifecycle("onCreate")
        enableEdgeToEdge()
        setContent {
            val widthClass = calculateWindowSizeClass(this@MainActivity).widthSizeClass

            Module3Theme {
                AppNavigation(
                    widthSizeClass = widthClass,
                    counterViewModel = counterViewModel,
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        logLifecycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycle("onResume")
    }

    override fun onPause() {
        logLifecycle("onPause")
        super.onPause()
    }

    override fun onStop() {
        logLifecycle("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        logLifecycle("onDestroy")
        super.onDestroy()
    }

    private fun logLifecycle(method: String) {
        Log.d(LIFECYCLE_TAG, method)
    }

    private companion object {
        const val LIFECYCLE_TAG = "Module3Lifecycle"
    }
}

