package de.ths.thshift.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.ths.thshift.ui.screen.EventScreen
import de.ths.thshift.ui.theme.THShiftTheme

@Composable
fun THShift(
    modifier: Modifier = Modifier
) {
    EventScreen(modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    THShiftTheme {
        THShift()
    }
}