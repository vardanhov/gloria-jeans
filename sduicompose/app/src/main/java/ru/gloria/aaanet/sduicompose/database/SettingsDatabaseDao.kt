package ru.gloria.aaanet.sduicompose.database

import androidx.room.*

@Dao
interface SettingsDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(setting: SettingModel)

    @Update
    suspend fun update(setting: SettingModel)

    @Query("SELECT * from settings where id = 0")
    suspend fun get(): SettingModel?
}