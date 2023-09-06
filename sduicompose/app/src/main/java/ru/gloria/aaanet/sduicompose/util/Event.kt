package ru.gloria.aaanet.sduicompose.util

sealed class Event{
    data class ScannerEvent(
        val labelType: String,
        val dataString: String
    ) : Event()
}