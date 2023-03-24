package de.ths.thshift.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.ths.thshift.domain.api.event.EventViewModel
import de.ths.thshift.ui.screen.event.EventItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun EventScreen(
    modifier: Modifier = Modifier,
    viewModel: EventViewModel = koinViewModel()
) = with(viewModel) {
    val events by allEvents.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = modifier
            .padding(10.dp)
    ) {
        items(events) { event ->
            EventItem(event)
        }
    }
}