package de.ths.thshift.domain.api.event

import androidx.lifecycle.ViewModel

abstract class EventViewModel :
    ViewModel(), EventPresenter
{
    /**
     * Reloads all events.
     */
    abstract fun refresh()
}