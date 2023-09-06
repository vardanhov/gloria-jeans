package ru.gloria.aaanet.sduicompose

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.gloria.aaanet.sduicompose.data.remote.responses.ScanResponse
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.*
import ru.gloria.aaanet.sduicompose.database.SettingModel
import ru.gloria.aaanet.sduicompose.scanner.ScanBroadcastReciever
import ru.gloria.aaanet.sduicompose.ui.theme.SDUIComposeTheme
import ru.gloria.aaanet.sduicompose.util.Device
import ru.gloria.aaanet.sduicompose.util.Event
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainActivityViewModel = hiltViewModel()
            settingsStateCompanion.value = viewModel.settings.value
            FillFullScreenActivator()
            SDUIComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }

    companion object {
        private var afterShowModalFlag = mutableStateOf(1)
        private var settingsStateCompanion = mutableStateOf(SettingModel())
        fun afterShowModal() {
            afterShowModalFlag.value *= -1
        }

        fun updateSettings(settingsState: SettingModel) {
            settingsStateCompanion.value = settingsState
        }
    }

    @Composable
    private fun FillFullScreenActivator() {
        val afterShowModal by remember { afterShowModalFlag }
        val settingsLocal by remember { settingsStateCompanion }

        if (settingsLocal.enableFullScreenMode) {
            FillFullScreen(afterShowModal)
        } else {
            ExitFullScreen(afterShowModal)
        }
    }

    @Composable
    @Suppress("UNUSED_VARIABLE")
    private fun FillFullScreen(flag: Int) {
        val state: Int by remember { mutableStateOf(flag) }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, LocalView.current).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    @Composable
    @Suppress("UNUSED_VARIABLE")
    private fun ExitFullScreen(flag: Int) {
        val state by remember { mutableStateOf(flag) }
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            LocalView.current
        ).show(WindowInsetsCompat.Type.systemBars())
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "sdui") {
        composable("sdui") {
            ScreenEntryPoint(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
    }
}

@Composable
fun CustomTextField(
    textField: TextField,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var state by remember {
        mutableStateOf("")
    }
    if (textField.value.value.isNotEmpty())
        state = viewModel.getValue(textField.value).toString()

    DisposableEffect(textField, focusManager) {
        onDispose {
            focusManager.clearFocus()
        }
    }

    OutlinedTextField(
        value = state,
        onValueChange = {
            state = it
            viewModel.setValue(textField.value, it)
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp, lineHeight = 24.sp),
        modifier = modifier
            .focusRequester(focusRequester)
            .onGloballyPositioned {
                if (textField.autoFocus) {
                    focusRequester.requestFocus() // IMPORTANT
                }

            },
        placeholder = {
            if (textField.placeholder != null) {
                Text(
                    text = viewModel.getValue(textField.placeholder).toString(),
                    color = Gray
                )
            }
        },
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()

            if (textField.clickAction != null) {
                viewModel.toAction(
                    textField.clickAction!!.actionUri,
                    viewModel.getValue(textField.clickAction.callbackData)
                )
            }
        }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = MapKeyboardType(textField.keyboardType)
        ),
        singleLine = textField.singleLine,
        label = {
            if (textField.label != null) {
                Text(
                    text = viewModel.getValue(textField.label).toString(),
                    color = Gray

                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray
        )
    )
}

@Composable
fun ScanReciever(
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    ScanBroadcastReciever { event: Event ->
        when (event) {
            is Event.ScannerEvent -> {
                viewModel.screen.value.scanAction?.let {
                    viewModel.toScanAction(
                        data = viewModel.getValue(it.callbackData),
                        scanResponse = ScanResponse(
                            LDATA_TYPE = event.labelType,
                            LDATA_STRING = event.dataString.replace(Char(0x1d), ' ')
                        ),
                        url = it.actionUri
                    )
                }
            }
        }
    }
}

@Composable
fun ScanManualModal(
    dataContext: Any?,
    scanAction: ScanAction,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val show by remember {
        viewModel.showScanManualModal
    }

    if (show) {
        DisposableEffect(scanAction) {
            onDispose {
                MainActivity.afterShowModal()
            }
        }

        var codeType by remember { mutableStateOf("") }
        var codeData by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = {
                viewModel.showScanManualModal.value = false

            },
            title = {},
            text = {
                Column {
                    OutlinedTextField(
                        value = codeType,
                        onValueChange = {
                            codeType = it
                        },
                        placeholder = {
                            Text("ex: (LABEL-TYPE-EAN13)")
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = codeData,
                        onValueChange = {
                            codeData = it
                        },
                        placeholder = {
                            Text("ex: (3060400003099)")
                        }
                    )
                }
            },
            buttons = {
                Row {
                    Button(
                        onClick = {
                            viewModel.toScanAction(
                                data = dataContext,
                                url = scanAction.actionUri,
                                scanResponse = ScanResponse(
                                    codeType,
                                    codeData.replace(Char(0x1d), ' ')
                                )
                            )
                            viewModel.showScanManualModal.value = false
                        },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp)

                    ) {
                        Text("Scan")
                    }
                }
            }
        )
    }
}

@Composable
fun CustomFABScan(
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    FloatingActionButton(
        onClick = {
            viewModel.showScanManualModal.value = true
        }
    ) {
        Icon(Icons.Filled.CheckCircle, contentDescription = null)
    }
}

@Composable
fun CustomDialog(
    modalDialog: ModalDialog,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    var show by remember { mutableStateOf(false) }

    DisposableEffect(modalDialog) {

        show = modalDialog.showModal

        onDispose {
            MainActivity.afterShowModal()
        }
    }

    if (show) {
        AlertDialog(
            onDismissRequest = { },
            title = {
                if (modalDialog.header.value.isNotEmpty()) {
                    Text(
                        text = viewModel.getValue(modalDialog.header).toString()
                    )
                }
            },
            text = {
                Text(
                    text = viewModel.getValue(modalDialog.message).toString()
                )
            },
            buttons = {
                Row {
                    modalDialog.buttons.map {
                        MapElement(
                            it,
                            Modifier.mapModifiers(it.modifiers, this),
                            buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers)
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun CustomTopAppBar(
    header: Header?
) {
    if (header?.contents != null) {
        TopAppBar(
            content = {
                var index = 0
                header.contents.map {
                    MapElement(it)
                    if (index == 1) {
                        Spacer(Modifier.weight(1f, true))
                    }
                    index++
                }
            }
        )
    }
}

@Composable
fun CustomBottomAppBar(
    footer: Footer
) {
    BottomAppBar {
        MapElement(item = footer.content)
        Spacer(Modifier.weight(1f, true))
        footer.buttons?.map {
            MapElement(it, buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers))
        }
    }
}

@Composable
fun ScreenEntryPoint(
    navController: NavController,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val screen by remember { viewModel.screen }
    val hasLoadError by remember { viewModel.hasLoadError }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }
    val screenRevision by remember { viewModel.screenRevision }
    val settingsState by remember { viewModel.settings }

    MainActivity.updateSettings(settingsState)

    Box(modifier = Modifier.fillMaxSize()) {
        LoadIndicator(Modifier.align(Alignment.Center), isLoading)
        if (hasLoadError) {
            LoadError(
                loadError = loadError,
                viewModel = viewModel,
                navController = navController
            )
        } else {
            SDUIScreen(screen, screenRevision, navController)
        }
    }
}

@Composable
fun LoadError(
    loadError: String,
    viewModel: MainActivityViewModel = hiltViewModel(),
    navController: NavController
) {
    ErrorWithRefreshButton(loadError = loadError, navController = navController) {
        if (viewModel.latestUri.value.isNotEmpty()) {
            viewModel.toAction(
                viewModel.latestUri.value,
                viewModel.latestDataContext.value
            )
        } else {
            viewModel.viewModelScope.launch {
                viewModel.loadData()
            }

        }
    }
}

@Composable
fun AppInfo() {
    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.gj_icon),
            contentDescription = "Logo",
            modifier = Modifier.size(64.dp)
        )

        Text(
            text = "RDT App",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun DeviceInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 10.dp)
    ) {
        Spacer(Modifier.height(10.dp))
        Row(Modifier.padding(10.dp)) {
            Text("Wifi MAC: ", color = Gray)
            Text(Device.getMacAddr(), color = Gray)

            //Text("Серийный номер: ", color = Gray)
            //Text(Device.getSerialNumber(), color = Gray)
        }
        Row(Modifier.padding(10.dp)) {
            Text("Производитель: ", color = Gray)
            Text(Device.getDeviceManufacturer(), color = Gray)
        }
        Row(Modifier.padding(10.dp)) {
            Text("Модель: ", color = Gray)
            Text(Device.getDeviceModel(), color = Gray)
        }
    }
}

@Composable
@Suppress("UNUSED_PARAMETER")
fun SDUIScreen(
    screen: Screen,
    screenRevision: Int,
    navController: NavController,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val settings by remember { viewModel.settings }

    Scaffold(
        drawerContent = {
            AppDrawer {
                NavigationMenu(navController) { nav ->
                    OutlinedButton(
                        onClick = {
                            nav.navigate("settings") {
                                popUpTo("sdui") { inclusive = true }
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
                            Icon(Icons.Filled.Settings, contentDescription = null)
                            Spacer(modifier = Modifier.width(30.dp))
                            Text("Настройки", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        },
        topBar = {
            if (screen.header != null) {
                CustomTopAppBar(screen.header)
            }
        },
        bottomBar = {
            if (screen.footer != null) {
                CustomBottomAppBar(screen.footer)
            }
        },
        floatingActionButton = {
            if (screen.scanAction != null && settings.enableVirtualScanButton) {
                CustomFABScan()
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        if (screen.modalDialog != null) {
            CustomDialog(screen.modalDialog)
        }
        if (screen.scanAction != null) {
            ScanReciever()
            ScanManualModal(dataContext = screen.dataContext, scanAction = screen.scanAction)
        }
        Column(modifier = Modifier.padding(it)) {
            screen.items.map { composable ->
                MapElement(
                    composable,
                    Modifier.mapModifiers(composable.modifiers, this),
                    buttonBackgroundColor = mapButtonBackgroundColor(composable.modifiers)
                )
            }
        }
    }
}

@Composable
fun LoadIndicator(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false
) {
    if (isLoading) {
        var show by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(true) {
            delay(200)
            show = true
        }

        if (show) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .zIndex(9999f)
                    .background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Загрузка",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun ErrorWithRefreshButton(
    loadError: String,
    navController: NavController,
    loadCallback: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(Modifier.align(Alignment.BottomCenter)) {
            Button(
                onClick = {
                    loadCallback()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)

            ) {
                Text(
                    text = "Обновить"
                )
            }
            Button(
                onClick = {
                    navController.navigate("settings")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Настройки"
                )
            }
        }

        Text(
            text = loadError,
            color = Red,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.Center)
        )
    }
}

fun mapButtonBackgroundColor(
    modifiers: List<ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Modifier>,
): Color? {
    modifiers.forEach {
        if (it.background != null && it.background.color != null) {
            return Color(
                it.background.color.red,
                it.background.color.green,
                it.background.color.blue,
                it.background.color.alpha,
            )
        }

    }
    return null
}

fun <T> Modifier.mapModifiers(
    modifiers: List<ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Modifier>,
    layoutScope: T? = null
): Modifier {
    var modifier = this
    modifiers.forEach {
        if (it.width != null) {
            modifier = modifier.width(it.width.dp)
        }

        if (it.height != null) {
            modifier = modifier.height(it.height.dp)
        }

        if (it.fillMaxSize != null && it.fillMaxSize) {
            modifier = modifier.fillMaxSize()
        }

        if (it.fillMaxWidth != null && it.fillMaxWidth) {
            modifier = modifier.fillMaxWidth()
        }

        if (it.fillMaxHeight != null && it.fillMaxHeight) {
            modifier = modifier.fillMaxHeight()
        }

        if (it.padding != null) {
            modifier = modifier.padding(it.padding.dp)
        }

        if (it.paddingVertical != null) {
            modifier = modifier.padding(vertical = it.paddingVertical.dp)
        }

        if (it.paddingHorizontal != null) {
            modifier = modifier.padding(horizontal = it.paddingHorizontal.dp)
        }

        if (it.intrinsicSizeHeight != null) {
            when (it.intrinsicSizeHeight) {
                IntrinsicSize.Min -> modifier = modifier.height(IntrinsicSize.Min)
                IntrinsicSize.Max -> modifier = modifier.height(IntrinsicSize.Max)
            }
        }

        if (it.intrinsicSizeWidth != null) {
            when (it.intrinsicSizeWidth) {
                IntrinsicSize.Min -> modifier = modifier.height(IntrinsicSize.Min)
                IntrinsicSize.Max -> modifier = modifier.height(IntrinsicSize.Max)
            }
        }

        if (it.background != null) {
            if (it.background.shape == null && it.background.gradient == null) {
                modifier = modifier.background(
                    Color(
                        it.background.color.red,
                        it.background.color.green,
                        it.background.color.blue,
                        it.background.color.alpha,
                    )
                )
            } else if (it.background.shape != null && it.background.gradient == null) {
                modifier = modifier.background(
                    Color(
                        it.background.color.red,
                        it.background.color.green,
                        it.background.color.blue,
                        it.background.color.alpha,
                    ),
                    when (it.background.shape.clipShape) {
                        ClipShape.CircleShape -> CircleShape
                        ClipShape.RectangleShape -> RectangleShape
                        ClipShape.CutCornerShape -> CutCornerShape(it.background.shape.percent.dp)
                        ClipShape.RoundedCornerShape -> RoundedCornerShape(it.background.shape.percent.dp)
                    }
                )
            } else {
                modifier = modifier.background(
                    when (it.background.gradient.direction) {
                        GradientDirection.Horizontal -> Brush.horizontalGradient(
                            it.background.gradient.colors.mapNotNull { x ->
                                Color(
                                    x.red,
                                    x.green,
                                    x.blue,
                                    x.alpha
                                )
                            },
                            it.background.gradient.startX,
                            it.background.gradient.endX,
                            when (it.background.gradient.tile) {
                                TileMode.Clamp -> androidx.compose.ui.graphics.TileMode.Clamp
                                TileMode.Repeated -> androidx.compose.ui.graphics.TileMode.Repeated
                                TileMode.Mirror -> androidx.compose.ui.graphics.TileMode.Mirror
                            }
                        )
                        GradientDirection.Vertical -> Brush.verticalGradient(
                            it.background.gradient.colors.mapNotNull { x ->
                                Color(
                                    x.red,
                                    x.green,
                                    x.blue,
                                    x.alpha
                                )
                            },
                            it.background.gradient.startX,
                            it.background.gradient.endX,
                            when (it.background.gradient.tile) {
                                TileMode.Clamp -> androidx.compose.ui.graphics.TileMode.Clamp
                                TileMode.Repeated -> androidx.compose.ui.graphics.TileMode.Repeated
                                TileMode.Mirror -> androidx.compose.ui.graphics.TileMode.Mirror
                            }
                        )
                    },
                    when (it.background.shape.clipShape) {
                        ClipShape.CircleShape -> CircleShape
                        ClipShape.RectangleShape -> RectangleShape
                        ClipShape.CutCornerShape -> CutCornerShape(it.background.shape.percent.dp)
                        ClipShape.RoundedCornerShape -> RoundedCornerShape(it.background.shape.percent.dp)
                    }
                )
            }
        }

        if (it.border != null) {
            modifier = modifier.border(
                BorderStroke(
                    width = it.border.width.dp,
                    color = Color(
                        it.border.color.red,
                        it.border.color.green,
                        it.border.color.blue,
                        it.border.color.alpha
                    )
                ),
                shape = if (it.border.shape != null) {
                    when (it.border.shape.clipShape) {
                        ClipShape.CircleShape -> CircleShape
                        ClipShape.RectangleShape -> RectangleShape
                        ClipShape.CutCornerShape -> CutCornerShape(it.border.shape.percent.dp)
                        ClipShape.RoundedCornerShape -> RoundedCornerShape(it.border.shape.percent.dp)
                    }
                } else {
                    RectangleShape
                }
            )
        }

        if (it.alpha != null) {
            modifier = modifier.alpha(it.alpha)
        }

        if (it.clip != null) {
            modifier = when (it.clip.clipShape) {
                ClipShape.CircleShape -> modifier.clip(CircleShape)
                ClipShape.RectangleShape -> modifier.clip(RectangleShape)
                ClipShape.CutCornerShape -> modifier.clip(CutCornerShape(it.clip.percent))
                ClipShape.RoundedCornerShape -> modifier.clip(RoundedCornerShape(it.clip.percent))
            }
        }

        if (it.size != null) {
            modifier = modifier.size(it.size.dp)
        }

        if (it.offset != null) {
            modifier = modifier.offset(
                it.offset.x.dp,
                it.offset.y.dp
            )
        }

        if (it.shadow != null) {
            modifier = modifier.shadow(
                elevation = it.shadow.elevation.dp,
                shape = when (it.shadow.shape.clipShape) {
                    ClipShape.CircleShape -> CircleShape
                    ClipShape.RectangleShape -> RectangleShape
                    ClipShape.CutCornerShape -> CutCornerShape(it.shadow.shape.percent)
                    ClipShape.RoundedCornerShape -> RoundedCornerShape(it.shadow.shape.percent)
                }
            )
        }

        if (layoutScope != null) {
            with(layoutScope) {
                when (this) {
                    is RowScope -> {
                        if (it.weight != null) {
                            modifier = modifier.weight(it.weight)
                        }
                    }
                    is ColumnScope -> {
                        if (it.weight != null) {
                            modifier = modifier.weight(it.weight)
                        }
                    }
                    is LazyListScope -> {
                    }
                    is LazyItemScope -> {
                    }
                    else -> throw NotImplementedError("Unsupported layoutScope")
                }
            }
        }
    }

    return modifier
}

@Composable
fun MapElement(
    item: ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Composable,
    modifier: Modifier = Modifier,
    buttonBackgroundColor: Color? = null,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val mod = modifier.let {
        if (item.clickAction != null) {
            it.clickable {
                viewModel.toAction(
                    item.clickAction!!.actionUri,
                    viewModel.getValue(item.clickAction!!.callbackData)
                )
            }
        } else {
            it
        }
    }

    when (item.elementType) {
        ElementType.Text -> CustomText(item as Text, mod)
        ElementType.TextField -> CustomTextField(item as TextField, mod)
        ElementType.Button -> CustomButton(item as Button, mod, buttonBackgroundColor)
        ElementType.ButtonOutLine -> CustomButtonOutLine(item as ButtonOutLine, mod)
        ElementType.IconButton -> CustomIconButton(item as IconButton, mod)
        ElementType.Container -> MapContainer(item as Container, mod)
        ElementType.Divider -> CustomDivider(divider = item as Divider)
        ElementType.Spacer -> CustomSpacer(mod)
        ElementType.Image -> CustomImage(
            item as ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Image,
            mod
        )
        ElementType.DatePicker -> CustomDatePicker(
            item as ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.DatePicker,
            mod
        )
        ElementType.Spinner -> CustomSpinner(
            item as ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Spinner,
            mod
        )
        ElementType.MultiSelector -> CustomMultiSelectDropdown(
            item as ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.MultiSelector
        )
    }
}

@Composable
fun CustomSpacer(
    modifier: Modifier = Modifier
) {
    Spacer(modifier)
}

@Composable
fun MapContainer(
    container: Container,
    modifier: Modifier = Modifier.background(Color.White),
) {
    when (container.direction) {
        DirectionType.Vertical -> {
            if (container.hasScroll) {
                LazyColumn(
                    modifier
                ) {
                    items(container.items) {
                        MapElement(
                            item = it,
                            Modifier.mapModifiers(it.modifiers, this),
                            buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers)
                        )
                    }
                }
            } else {
                if (container.isCollapse) {
                    CardContentExpandable(container);
                } else {
                    Column(modifier) {
                        container.items.map {
                            MapElement(
                                it,
                                Modifier.mapModifiers(it.modifiers, this),
                                buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers)
                            )
                        }
                    }
                }
            }
        }
        DirectionType.Horizontal -> {
            if (container.hasScroll) {
                LazyRow(modifier) {
                    items(container.items) {
                        MapElement(
                            item = it,
                            Modifier.mapModifiers(it.modifiers, this),
                            buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers)
                        )
                    }
                }
            } else {
                Row(modifier) {
                    container.items.map {
                        MapElement(
                            it,
                            Modifier.mapModifiers(it.modifiers, this),
                            buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomDivider(
    divider: Divider
) {
    when (divider.direction) {
        DirectionType.Horizontal ->
            Divider()
        DirectionType.Vertical ->
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
            )
    }
}

@Composable
fun CustomText(
    text: Text,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    Text(
        text = viewModel.getValue(text.content).toString(),
        modifier = modifier.let {
            if (text.clickAction != null) {
                it.clickable {
                    viewModel.toAction(
                        text.clickAction.actionUri,
                        viewModel.getValue(text.clickAction.callbackData)
                    )
                }
            } else {
                it
            }
        },
        textAlign = TextAlign.fromValue(text.textAlign),
        fontSize = text.fontSize.sp,
        fontStyle = FontStyle(text.fontStyle),
        fontWeight = FontWeight(text.fontWeight),
        color = if (text.color != null) {
            Color(
                text.color.red,
                text.color.green,
                text.color.blue,
                text.color.alpha,
            )
        } else {
            Color.Unspecified
        }
    )
}

fun TextAlign.Companion.fromValue(value: Int): TextAlign {
    return when (value) {
        1 -> Left
        2 -> Right
        3 -> Center
        4 -> Justify
        5 -> Start
        6 -> End
        else -> Center
    }
}

@Composable
fun CustomIconButton(
    iconButton: IconButton,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    if (iconButton.clickAction != null) {
        IconButton(
            onClick = {
                viewModel.toAction(
                    iconButton.clickAction!!.actionUri,
                    viewModel.getValue(
                        iconButton.clickAction.callbackData
                    )
                )
            },
            modifier = modifier
        ) {
            when (iconButton.icon) {
                Icon.Refresh -> Icon(Icons.Filled.Refresh, contentDescription = null)
                Icon.Plus -> Icon(Icons.Filled.Add, contentDescription = null)
                Icon.Minus -> Icon(Icons.Filled.Delete, contentDescription = null)
                Icon.Burger -> Icon(Icons.Filled.MoreVert, contentDescription = null)
                Icon.Column -> Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color.Gray
                )
                Icon.Search -> Icon(Icons.Filled.Search, contentDescription = null)
                Icon.Back -> Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    } else {
        var taskMenuOpen by remember { mutableStateOf(false) }
        IconButton(
            onClick = {
                taskMenuOpen = true
            },
            modifier = modifier
        ) {
            when (iconButton.icon) {
                Icon.Refresh -> Icon(Icons.Filled.Refresh, contentDescription = null)
                Icon.Plus -> Icon(Icons.Filled.Add, contentDescription = null)
                Icon.Minus -> Icon(Icons.Filled.Delete, contentDescription = null)
                Icon.Burger -> Icon(Icons.Filled.MoreVert, contentDescription = null)
                Icon.Column -> Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color.Gray
                )
                Icon.Search -> Icon(Icons.Filled.Search, contentDescription = null)
                Icon.Back -> Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
            CustomDropdownMenu(
                expanded = taskMenuOpen,
                onDismiss = {
                    taskMenuOpen = false
                },
                iconButton.dropdownMenu
            )
        }
        taskMenuOpen = false
    }
}

@Composable
fun CustomButton(
    button: Button,
    modifier: Modifier = Modifier,
    buttonBackgroundColor: Color? = null,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    if (buttonBackgroundColor == null) {
        Button(
            onClick = {
                viewModel.toAction(
                    button.clickAction!!.actionUri,
                    viewModel.getValue(button.clickAction.callbackData)
                )
            },
            modifier = modifier,
        ) {
            MapElement(item = button.content)
        }
    } else {
        Button(
            onClick = {
                viewModel.toAction(
                    button.clickAction!!.actionUri,
                    viewModel.getValue(button.clickAction.callbackData)
                )
            },
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(buttonBackgroundColor),
        ) {
            MapElement(item = button.content)
        }
    }
}

@Composable
fun CustomButtonOutLine(
    buttonOutLine: ButtonOutLine,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    OutlinedTextField(
        value = viewModel.getValue(buttonOutLine.textField.value).toString(),
        onValueChange = {
        },
        modifier = modifier,
        enabled = false,
        label = {
            if (buttonOutLine.textField.label != null) {
                Text(
                    text = viewModel.getValue(buttonOutLine.textField.label).toString(),
                )
            }
        },
        textStyle = TextStyle(fontSize = 16.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
            backgroundColor = Color.Transparent,
            disabledBorderColor = Color(238, 238, 238, 255),
            disabledLabelColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
        ),
    )
}


@Composable
fun CustomImage(
    image: ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.Image,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {

    if (!image.image.isNullOrEmpty()) {
        val decodedString: ByteArray = Base64.decode(image.image, Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = modifier
        )
    } else if (image.url != null) {
        AsyncImage(
            model = viewModel.getValue(image.url),
            contentDescription = "",
            modifier = modifier
        )
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
fun CustomDatePicker(
    datePicker: ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.DatePicker,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    if (viewModel.getValue(datePicker.textField.value).toString().equals("")) {
        mCalendar.time = Date()
    } else {
        val current = viewModel.getValue(datePicker.textField.value).toString()
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        mCalendar.time = formatter.parse(current)
    }
    val mDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker,
          mYear: Int,
          mMonth: Int,
          mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth.${mMonth + 1}.$mYear"
        },
        mYear,
        mMonth,
        mDay
    )
    mDatePickerDialog.datePicker.firstDayOfWeek = Calendar.MONDAY
    val focusManager = LocalFocusManager.current
    DisposableEffect(datePicker.textField, focusManager) {
        onDispose {
            focusManager.clearFocus()
        }
    }
    OutlinedTextField(
        value = mDate.value,
        onValueChange = {
        },
        textStyle = TextStyle(fontSize = 16.sp),
        modifier = modifier,
        placeholder = {
            if (datePicker.textField.placeholder != null) {
                Text(
                    text = viewModel.getValue(datePicker.textField.placeholder).toString(),

                    )
            }
        },
        interactionSource = remember { MutableInteractionSource() }
            .also { interactionSource ->
                LaunchedEffect(interactionSource) {
                    interactionSource.interactions.collect {
                        if (it is PressInteraction.Release) {
                            mDatePickerDialog.show()
                        }
                    }
                }
            },
        readOnly = true,
        label = {
            if (datePicker.textField.label != null) {
                Text(
                    text = viewModel.getValue(datePicker.textField.label).toString()
                )
            }
        }
    )
    viewModel.setValue(datePicker.textField.value, mDate.value)
}

@Composable
fun CustomSpinner(
    spinner: Spinner,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    var expanded by remember { mutableStateOf(false) }
    val suggestions: List<String> =
        viewModel.getValue(spinner.content.content).toString().split(",")
    var selectedText by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    OutlinedTextField(
        readOnly = true,
        value = selectedText,
        onValueChange = { selectedText = it },
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                textFieldSize = coordinates.size.toSize()
            },

        trailingIcon = {
            Icon(icon, "contentDescription",
                Modifier.clickable { expanded = !expanded })
        },
        singleLine = true
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = modifier
            .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
    ) {
        suggestions.forEach { label ->
            DropdownMenuItem(onClick = {
                selectedText = label
                expanded = false
            }) {
                Text(text = label)
            }
        }
    }
}

@Composable
fun CustomDropdownMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    dropdownMenu: DropdownMenu,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    var expanded = expanded
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss,
        modifier = Modifier
            .mapModifiers(
                dropdownMenu.modifiers,
                null
            )
            .padding(0.dp)
            .widthIn(min = 220.dp)
            .heightIn(min = 33.dp)
    ) {
        dropdownMenu.dropdownMenuItems.forEach { option ->
            DropdownMenuItem(
                enabled = option.enabled,
                onClick = {
                    expanded = false
                    viewModel.toAction(
                        option.clickAction.actionUri,
                        viewModel.getValue(option.clickAction.callbackData)
                    )
                },
                modifier = Modifier
                    .padding(0.dp)
                    .widthIn(min = 220.dp)
                    .height(33.dp)
            ) {
                Text(
                    text = viewModel.getValue(option.text).toString(),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .widthIn(min = 220.dp)
                )
            }
            if (option != dropdownMenu.dropdownMenuItems.last()) {
                Divider()
            }
        }
    }
}

@Composable
fun CardContentExpandable(container: Container) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 6.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 0.dp, horizontal = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = container.collapseButtonText,
                    color = Color(
                        container.collapseButtonColor.red,
                        container.collapseButtonColor.green,
                        container.collapseButtonColor.blue,
                        container.collapseButtonColor.alpha,
                    ),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        painter = if (expanded) painterResource(id = R.drawable.expand_less) else painterResource(
                            id = R.drawable.expand_more
                        ),
                        contentDescription = if (expanded) {
                            stringResource(id = R.string.app_name)
                        } else {
                            stringResource(id = R.string.appbar_scrolling_view_behavior)
                        }
                    )
                }
            }
            if (expanded) {
                container.items.map {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 3.dp)
                            .fillMaxWidth()
                        // verticalAlignment = Alignment.CenterVertically
                    ) {
                        MapElement(
                            it,
                            Modifier.mapModifiers(it.modifiers, this),
                            buttonBackgroundColor = mapButtonBackgroundColor(it.modifiers)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MapKeyboardType(
    keyboardType: TextFieldKeyboardType,
): KeyboardType {
    var originalKeyboardType: KeyboardType

    when (keyboardType) {
        TextFieldKeyboardType.Ascii -> {
            originalKeyboardType = KeyboardType.Ascii
        }
        TextFieldKeyboardType.Decimal -> {
            originalKeyboardType = KeyboardType.Decimal
        }
        TextFieldKeyboardType.Email -> {
            originalKeyboardType = KeyboardType.Email
        }
        TextFieldKeyboardType.Number -> {
            originalKeyboardType = KeyboardType.Number
        }
        TextFieldKeyboardType.NumberPassword -> {
            originalKeyboardType = KeyboardType.NumberPassword
        }
        TextFieldKeyboardType.Password -> {
            originalKeyboardType = KeyboardType.Password
        }
        TextFieldKeyboardType.Phone -> {
            originalKeyboardType = KeyboardType.Phone
        }
        TextFieldKeyboardType.Text -> {
            originalKeyboardType = KeyboardType.Text
        }
        TextFieldKeyboardType.Uri -> {
            originalKeyboardType = KeyboardType.Uri
        }
    }

    return originalKeyboardType;
}

@Composable
fun CustomMultiSelectDropdown(
    multiSelector: MultiSelector,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    var expanded by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var filteredItems by remember { mutableStateOf(multiSelector.statusList) }
    var selectedRemember by remember { mutableStateOf(emptyList<String>()) }

    val onStatusSelected = { newSelectedItems: List<String> ->
        selectedRemember = newSelectedItems
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val textFieldState = remember { mutableStateOf("") }

        OutlinedTextField(
            value = textFieldState.value,
            onValueChange = {},
            enabled = false,
            readOnly = true,
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { expanded = !expanded }
            ),
            label = {
                if (multiSelector.labelStatus.content != null) {
                    Text(
                        text = viewModel.getValue(multiSelector.labelStatus.content).toString()
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 6.dp)
                .clickable {
                    expanded = true
                },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
                backgroundColor = Color.Transparent,
                disabledBorderColor = Color.Gray,
                disabledLabelColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
            ),
        )

        if (expanded) {
            val dropdownModifier = Modifier
                .align(Alignment.Start)
                .width(160.dp)
                .padding(horizontal = 12.dp)
            DropdownMenu(
                modifier = dropdownModifier,
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                    textFieldState.value = selectedRemember.joinToString(", ")
                }
            ) {
                multiSelector.statusList.forEach { item ->
                    val isSelected = selectedRemember.contains(item)

                    DropdownMenuItem(
                        onClick = {
                            if (isSelected) {
                                onStatusSelected(selectedRemember.filter { it != item })
                            } else {
                                onStatusSelected(selectedRemember + item)
                            }
                            viewModel.setValue(multiSelector.selectedStatuses, selectedRemember)
                        },
                        modifier = Modifier
                            .width(150.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (isSelected) {
                                Icon(
                                    Icons.Default.Check,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .padding(end = 8.dp),
                                    tint = Color.Green // Set the color for the green check
                                )
                            }
                            Text(text = item.toString())
                        }
                    }
                }
            }
        }
    }
}