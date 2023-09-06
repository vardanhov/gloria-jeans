package ru.gloria.aaanet.sduicompose.repository

import dagger.hilt.android.scopes.ActivityScoped
import ru.gloria.aaanet.sduicompose.data.remote.Api
import ru.gloria.aaanet.sduicompose.data.remote.responses.ScanResponse
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Screen
import ru.gloria.aaanet.sduicompose.util.Device
import ru.gloria.aaanet.sduicompose.util.Resource
import javax.inject.Inject

@ActivityScoped
class ApiRepository @Inject constructor(
    private val api : Api,
    var logServiceUrl: String = ""
) {
    abstract class LogData constructor(
        val tsd: String = Device.getMacAddr(),
        val type: String,
        val url: String,
        val message: String? = null,
        val dataContext: Any? = null
    ) { }
    class LogInfo constructor(url: String, msg: String? = null) : LogData(type = "info", url = url, message = msg)
    class LogError constructor(url: String, msg: String?, data: Any? = null) : LogData(type = "error", url = url, message = msg, dataContext = data)

    suspend fun getData(url: String) : Resource<Screen>{
        val response = try{
            logInfo(url)
            api.getData(url)
        }catch (e: Exception){
            logError(url, e.message)
            return Resource.Error(e.message ?: "", e)
        }
        return Resource.Success(response)
    }

    suspend fun toAction(url: String, dataContext: Any?) : Resource<Screen>{
        val response = try{
            api.toAction(url, dataContext)
        } catch (e: Exception){
            logError(url, e.message, dataContext)
            return Resource.Error(e.message ?: "", e)
        }
        return Resource.Success(response)
    }

    suspend fun toScanAction(
        url: String,
        dataContext: Any?,
        scanResponse: ScanResponse
    ): Resource<Screen> {
        val response = try{
            api.toScanAction(
                url = url,
                dataContext = dataContext,
                LDATA_TYPE = scanResponse.LDATA_TYPE,
                LDATA_STRING = scanResponse.LDATA_STRING
            )
        } catch (e: Exception){
            logError(url, e.message, dataContext)
            return Resource.Error(e.message ?: "", e)
        }
        return Resource.Success(response)
    }

    private suspend fun logInfo(url: String, msg: String? = null)
    {
        try { api.log(logServiceUrl, LogInfo(url, msg)) }
        catch (e: Exception){}
    }

    private suspend fun logError(url: String, msg: String? = null, data: Any? = null)
    {
        try { api.log(logServiceUrl, LogError(url, msg, data)) }
        catch (e: Exception){}
    }
}