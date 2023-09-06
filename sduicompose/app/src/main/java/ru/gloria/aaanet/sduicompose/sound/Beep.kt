package ru.gloria.aaanet.sduicompose.sound

import android.media.AudioManager
import android.media.ToneGenerator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Beep{
    companion object{
        val DEFAULT_SUCCESS_DELAY = 200
        val DEFAULT_ERROR_DELAY = 400

        private val toneGenerator = ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100)

        fun beepSuccess(duration: Int = DEFAULT_SUCCESS_DELAY) {
            toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP, duration)
        }
        fun beepWarning(duration: Int = DEFAULT_ERROR_DELAY) {
            toneGenerator.startTone(ToneGenerator.TONE_CDMA_SOFT_ERROR_LITE, duration)
        }
        fun beepError(duration: Int = DEFAULT_ERROR_DELAY) {
            GlobalScope.launch {
                beepWarning()
                delay(duration.toLong())
                beepWarning()
            }
        }
    }
}