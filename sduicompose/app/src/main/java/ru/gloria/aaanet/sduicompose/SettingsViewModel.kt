package ru.gloria.aaanet.sduicompose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.gloria.aaanet.sduicompose.database.SettingModel
import ru.gloria.aaanet.sduicompose.repository.SettingsRepository
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    var url = mutableStateOf("")
    var error = mutableStateOf("")
    var settings = mutableStateOf(SettingModel())

    init {
        getSettings()
    }

    private fun getSettings() {
        viewModelScope.launch {
            settings.value = settingsRepository.getSettings()
            url.value = settings.value.baseUrl
        }
    }

    fun saveAndExit(
        navController: NavController
    ) {
        viewModelScope.launch {
            settingsRepository.updateSettings(settings.value)
            navController.navigate("sdui") {
                popUpTo("sdui") { inclusive = true }
            }
        }
    }
    fun exit(
        navController: NavController
    ) {
        viewModelScope.launch {
            settingsRepository.getSettings()
            navController.navigate("sdui") {
                popUpTo("sdui") { inclusive = true }
            }
        }
    }
}