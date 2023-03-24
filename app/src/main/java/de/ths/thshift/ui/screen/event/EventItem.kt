package de.ths.thshift.ui.screen.event

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.ths.thshift.domain.api.event.Event
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun EventItem(
    event: Event,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(10.dp)
    ) {
        Text("${format(event.from)} -> ${format(event.to)}")
    }
}

internal fun format(dateTime: LocalDateTime): String =
    dateTime.format(DateTimeFormatter.ISO_TIME)