package ru.gloria.aaanet.sduicompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.internal.LinkedTreeMap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.gloria.aaanet.sduicompose.data.remote.responses.ScanResponse
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.BindingProperty
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.ModalDialog
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Screen
import ru.gloria.aaanet.sduicompose.database.SettingModel
import ru.gloria.aaanet.sduicompose.repository.ApiRepository
import ru.gloria.aaanet.sduicompose.repository.SettingsRepository
import ru.gloria.aaanet.sduicompose.util.Resource
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: ApiRepository,
    val settingsRepository: SettingsRepository
) : ViewModel() {
    var screen = mutableStateOf(Screen())
    private val modal: MutableState<ModalDialog?> = mutableStateOf(null)
    var loadError = mutableStateOf("")
    var hasLoadError = mutableStateOf(false)
    var isLoading = mutableStateOf(false)
    var latestUri = mutableStateOf("")
    var latestDataContext = mutableStateOf<Any?>(null)
    private var latestScanResponse = mutableStateOf<ScanResponse?>(null)
    var showScanManualModal = mutableStateOf(false)
    var screenRevision = mutableStateOf(1)
    var settings = mutableStateOf(SettingModel())

    init {
        viewModelScope.launch {
            loadSettings()
            loadData()
        }

    }

    private suspend fun loadSettings(){
        settings.value = settingsRepository.getSettings()
        repository.logServiceUrl = settings.value.baseUrl + "/tsdWriteLog"
    }

    suspend fun loadData() {
        viewModelScope.launch {
            isLoading.value = true
            if(settings.value.baseUrl.isEmpty()){
                isLoading.value = false
                hasLoadError.value = true
                loadError.value = "Не установлен адрес сервера"
            } else {
                when (val result = repository.getData(settings.value.baseUrl)) {
                    is Resource.Success -> {
                        isLoading.value = false
                        screen.value = result.data ?: Screen()
                        modal.value = result.data?.modalDialog
                        hasLoadError.value = false
                    }
                    is Resource.Error -> {
                        isLoading.value = false
                        hasLoadError.value = true
                        loadError.value = result.message!!
                    }
                }
            }
        }
    }

    fun toAction(
        url: String,
        data: Any?
    ) {
        latestDataContext.value = data
        latestUri.value = url
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.toAction(url, data)) {
                is Resource.Success -> {
                    isLoading.value = false
                    screen.value = result.data ?: Screen()
                    modal.value = result.data?.modalDialog
                    hasLoadError.value = false
                }
                is Resource.Error -> {
                    isLoading.value = false
                    hasLoadError.value = true
                    loadError.value = result.message!!
                }
            }
        }
    }

    fun toScanAction(
        url: String,
        data: Any?,
        scanResponse: ScanResponse
    ) {
        latestDataContext.value = data
        latestUri.value = url
        latestScanResponse.value = scanResponse
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.toScanAction(url, data, scanResponse)) {
                is Resource.Success -> {
                    isLoading.value = false
                    screen.value = result.data ?: Screen()
                    modal.value = result.data?.modalDialog
                    hasLoadError.value = false
                }
                is Resource.Error -> {
                    isLoading.value = false
                    hasLoadError.value = true
                    loadError.value = result.message!!
                }
            }
        }
    }

    fun getValue(
        bindingProperty: BindingProperty
    ): Any? {
        if (bindingProperty.selfContained){
            return bindingProperty.value
        }

        var map = screen.value.dataContext
        val pathSplit = bindingProperty.value.split('.')

        return pathSplit.mapIndexed { index, path ->
            if (index < pathSplit.size - 1) {
                if (map is LinkedTreeMap<*, *>) {
                    if ((map as LinkedTreeMap<*, *>)[path] is ArrayList<*>) {
                        map = (map as LinkedTreeMap<*, *>)[path] as ArrayList<*>
                    } else {
                        map = (map as LinkedTreeMap<*, *>)[path]
                    }
                } else if (map is ArrayList<*>) {
                    map = (map as ArrayList<*>)[path.toInt()]
                } else {
                    map
                }
            } else {
                if (path.isEmpty()) {
                    map
                } else {
                    when (map) {
                        null -> {
                            null
                        }
                        is ArrayList<*> -> {
                            (map as ArrayList<*>)[path.toInt()]
                        }
                        else -> {
                            (map as LinkedTreeMap<*, *>)[path]
                        }
                    }
                }
            }
        }.last()
    }

    fun setValue(
        bindingProperty: BindingProperty,
        newValue: Any?
    ) {
        var map = screen.value.dataContext
        val pathSplit = bindingProperty.value.split('.')

        pathSplit.mapIndexed { index, path ->
            if (index < pathSplit.size - 1) {
                if (map is LinkedTreeMap<*, *>) {
                    if ((map as LinkedTreeMap<*, *>)[path] is ArrayList<*>) {
                        map = (map as LinkedTreeMap<*, *>)[path] as ArrayList<*>
                    } else {
                        map = (map as LinkedTreeMap<*, *>)[path]
                    }
                } else if (map is ArrayList<*>) {
                    map = (map as ArrayList<*>)[path.toInt()]
                } else {
                    map
                }
            } else {
                if (path.isEmpty()) {
                    map = newValue
                } else {
                    when (map) {
                        null -> {
                            null
                        }
                        is ArrayList<*> -> {
                            (map as ArrayList<Any?>).set(path.toInt(), newValue)
                        }
                        else -> {
                            (map as LinkedTreeMap<String, Any?>).set(path, newValue)
                        }
                    }
                }
            }
        }.last()

        //Стыд и позор всего проекта (Нормальная идея как обновлять данные не тратя память на рост числа за авторством Аскеровой Анастасии!)
        //Было screenRevision.value++ (ну ну, память же бесконечня)
        screenRevision.value *= -1
    }
}

