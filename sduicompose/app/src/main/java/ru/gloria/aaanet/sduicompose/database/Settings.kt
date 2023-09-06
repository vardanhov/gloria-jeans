package ru.gloria.aaanet.sduicompose.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class SettingModel(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo(name = "baseUrl")
    val baseUrl: String = "",
    @ColumnInfo(name = "enableVirtualScanButton")
    val enableVirtualScanButton: Boolean = false,
    @ColumnInfo(name = "enableFullScreenMode")
    val enableFullScreenMode: Boolean = false
)