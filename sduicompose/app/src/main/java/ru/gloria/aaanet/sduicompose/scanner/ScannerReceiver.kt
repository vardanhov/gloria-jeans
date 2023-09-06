package ru.gloria.aaanet.sduicompose.scanner

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import ru.gloria.aaanet.sduicompose.util.Constants
import ru.gloria.aaanet.sduicompose.util.Device
import ru.gloria.aaanet.sduicompose.util.Event

@Composable
fun ScanBroadcastReciever(
    onEvent: (event: Event) -> Unit
){
    val context = LocalContext.current

    DisposableEffect(context, Constants.SCAN_ACTION){
        val intentFilter = IntentFilter(Constants.SCAN_ACTION).also {
            it.addCategory(Intent.CATEGORY_DEFAULT)
        }
        val broadcastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context, intent: Intent) {

                if(Device.getDeviceManufacturer().contains("honeywell", true) )
                {
                    when(intent.extras?.getString("codeId")){
                        "d" -> {
                            intent.putExtra("com.symbol.datawedge.label_type", "LABEL-TYPE-EAN13")
                            intent.putExtra("com.motorolasolutions.emdk.datawedge.label_type", "LABEL-TYPE-EAN13")
                        }
                        "w" ->{
                            intent.putExtra("com.symbol.datawedge.label_type", "LABEL-TYPE-DATAMATRIX")
                            intent.putExtra("com.motorolasolutions.emdk.datawedge.label_type", "LABEL-TYPE-DATAMATRIX")
                        }
                        "s" ->{
                            intent.putExtra("com.symbol.datawedge.label_type", "LABEL-TYPE-QRCODE")
                            intent.putExtra("com.motorolasolutions.emdk.datawedge.label_type", "LABEL-TYPE-QRCODE")
                        }
                        "j" ->{
                            intent.putExtra("com.symbol.datawedge.label_type", "LABEL-TYPE-CODE128")
                            intent.putExtra("com.motorolasolutions.emdk.datawedge.label_type", "LABEL-TYPE-CODE128")
                        }
                        else -> {}
                    }
                    intent.putExtra("com.symbol.datawedge.data_string", intent.extras?.getString("data"))
                    intent.putExtra("com.symbol.datawedge.source", "scanner")
                }

                val labelType = intent
                    .extras
                    ?.getString("com.symbol.datawedge.label_type")
                    ?.substringAfterLast("-") ?: ""

                val dataString = intent
                    .extras
                    ?.getString("com.symbol.datawedge.data_string") ?: ""

                val event = Event.ScannerEvent(
                    labelType = labelType,
                    dataString = dataString
                )
                onEvent(event)
            }
        }
        context.registerReceiver(broadcastReceiver, intentFilter)
        onDispose {
            context.unregisterReceiver(broadcastReceiver)
        }
    }
}