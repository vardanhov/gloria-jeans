package ru.gloria.aaanet.sduicompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.gloria.aaanet.sduicompose.scanner.ScanBroadcastReciever
import ru.gloria.aaanet.sduicompose.util.Constants
import ru.gloria.aaanet.sduicompose.util.Event

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    var settings by remember { viewModel.settings }
    val error by remember { viewModel.error }

    Scaffold(
        drawerContent = {
            AppDrawer {
                NavigationMenu(navController) { nav ->
                    OutlinedButton(
                        onClick = {
                            nav.navigate("sdui") {
                                popUpTo("sdui"){ inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = null
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(Icons.Filled.Home, contentDescription = null)
                            Spacer(modifier = Modifier.width(30.dp))
                            Text("SDUI App", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Настройки",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.exit(navController)
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },

            )
        }
    ) {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize()) {

            Column(
                Modifier.padding(vertical = 25.dp, horizontal = 16.dp)
            ) {
                OutlinedTextField(
                    value = settings.baseUrl,
                    onValueChange = { input ->
                        settings = settings.copy(baseUrl = input)
                    },
                    placeholder = {
                        Text("", Modifier.fillMaxWidth(), textAlign = TextAlign.Justify)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Адрес сервера",
                            color= Gray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            viewModel.settings.value = settings
                            viewModel.saveAndExit(navController)
                        }
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = LightGray,
                        unfocusedBorderColor = LightGray)
                )

                Text(
                    text = "Введите адрес сервиса",
                    color = Gray, fontSize = 12.sp, textAlign = TextAlign.Right
                )

                Spacer(Modifier.height(50.dp))

//                CustomSwitch(
//                    checked = settings.enableFullScreenMode,
//                    label = "Полный экран",
//                    onSwitch = {
//                        settings = settings.copy(enableFullScreenMode = it)
//                    },
//                    modifier = Modifier
//
//                )

                CustomSwitch(
                    checked = settings.enableVirtualScanButton,
                    label = "Виртуальное сканирование",
                    onSwitch = {
                        settings = settings.copy(enableVirtualScanButton = it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                )
                Spacer(Modifier.height(10.5.dp))
                Button(
                    onClick = {
                        viewModel.settings.value = settings
                        viewModel.saveAndExit(navController)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(10.dp)
                ) {
                    Text(
                        "СОХРАНИТЬ",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    )
                }
                Spacer(Modifier.weight(0.1f))
            }
            if (error.isNotEmpty()){
                Text(
                    text = error,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }

    ScanBroadcastReciever{ event ->
        when (event){
            is Event.ScannerEvent -> {
                if (event.labelType == Constants.QR_LDATA_TYPE) {
                    settings = settings.copy(baseUrl = event.dataString)
                }
            }
        }
    }
}

@Composable
fun CustomSwitch(
    checked: Boolean,
    label: String,
    onSwitch: (value: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier.padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            textAlign = TextAlign.Left,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        Spacer(Modifier.weight(1f, true))
        Switch(checked = checked, onCheckedChange = { onSwitch(it) })
    }
}