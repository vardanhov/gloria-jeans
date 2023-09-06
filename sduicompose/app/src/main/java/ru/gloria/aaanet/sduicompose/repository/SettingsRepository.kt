package ru.gloria.aaanet.sduicompose.repository

import dagger.hilt.android.scopes.ActivityScoped
import ru.gloria.aaanet.sduicompose.database.SettingModel
import ru.gloria.aaanet.sduicompose.database.SettingsDatabaseDao

@ActivityScoped
class SettingsRepository(
    private val settingsDatabaseDao: SettingsDatabaseDao
) {
    private suspend fun createSettings(): SettingModel {
        val setting = SettingModel()
        settingsDatabaseDao.insert(setting)
        return setting
    }

    suspend fun getSettings(): SettingModel{
        val setting = settingsDatabaseDao.get() ?: createSettings()
        return setting
    }

    suspend fun updateSettings(settingModel: SettingModel) : SettingModel{
        settingsDatabaseDao.update(settingModel)
        return settingModel
    }
}