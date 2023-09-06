package ru.gloria.aaanet.sduicompose.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideSettingsDao(settingsDatabase: SettingsDatabase) = settingsDatabase.settingsDao()

    @Provides
    @Singleton
    fun provideSettingsDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        SettingsDatabase::class.java,
        "Settings"
    ).build()
}