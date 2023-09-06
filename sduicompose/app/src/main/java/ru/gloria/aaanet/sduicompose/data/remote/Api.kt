package ru.gloria.aaanet.sduicompose.data.remote

import retrofit2.http.*
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Screen

interface Api {
    @GET
    suspend fun getData(@Url url: String): Screen

    @POST
    suspend fun toAction(@Url url: String, @Body dataContext: Any?): Screen

    @POST
    suspend fun log(@Url url: String, @Body logData: Any?)

    @POST
    suspend fun toScanAction(
        @Url url: String,
        @Body dataContext: Any?,
        @Header("Scan-LDATA_TYPE") LDATA_TYPE: String,
        @Header("Scan-LDATA_STRING") LDATA_STRING: String
    ): Screen
}