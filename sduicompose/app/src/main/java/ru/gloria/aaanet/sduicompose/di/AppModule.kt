package ru.gloria.aaanet.sduicompose.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gloria.aaanet.sduicompose.adapters.jetpack_v2.*
import ru.gloria.aaanet.sduicompose.data.remote.Api
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.*
import ru.gloria.aaanet.sduicompose.database.SettingsDatabaseDao
import ru.gloria.aaanet.sduicompose.repository.ApiRepository
import ru.gloria.aaanet.sduicompose.repository.SettingsRepository
import ru.gloria.aaanet.sduicompose.util.Device
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApi(): Api {
        val gson = GsonBuilder()
            .registerTypeAdapter(Screen::class.java, JetpackDeserializer())
            .registerTypeAdapter(Composable::class.java, ComposableDeserializer())
            .registerTypeAdapter(ElementType::class.java, ElementTypeIntDeserializer())
            .registerTypeAdapter(DirectionType::class.java, DirectionIntDeserializer())
            .registerTypeAdapter(SignalType::class.java, SignalIntDeserializer())
            .registerTypeAdapter(Icon::class.java, IconIntDeserializer())
            .create()

        val okHttpClientBuilder = OkHttpClient.Builder()
//            .callTimeout(5, TimeUnit.SECONDS)
//            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
//            .writeTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(Interceptor {
                val original = it.request()
                val req = original
                    .newBuilder()
                    .header("Device-WifiMac", Device.getMacAddr())
                    .header("Device-Serial", Device.getSerialNumber())
                    .header("Device-Model", Device.getDeviceModel())
                    .header("Device-Manufacturer", Device.getDeviceManufacturer())
                    .build()
                it.proceed(req)
            })

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://server_base_url/")
            .client(okHttpClientBuilder.build())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideApiRepository(
        api: Api
    ) = ApiRepository(api)

    @Singleton
    @Provides
    fun provideSettingsRepository(settingsDatabaseDao: SettingsDatabaseDao) = SettingsRepository(settingsDatabaseDao)
}