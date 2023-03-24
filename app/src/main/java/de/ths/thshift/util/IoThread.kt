package de.ths.thshift.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

inline fun ViewModel.ioThread(
    crossinline block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(Dispatchers.IO) {
        block()
    }
}