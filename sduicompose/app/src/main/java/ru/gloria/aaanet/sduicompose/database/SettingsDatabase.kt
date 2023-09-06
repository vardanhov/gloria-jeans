package ru.gloria.aaanet.sduicompose.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SettingModel::class], version = 2, exportSchema = false)
abstract class SettingsDatabase : RoomDatabase() {
    abstract fun settingsDao(): SettingsDatabaseDao
}