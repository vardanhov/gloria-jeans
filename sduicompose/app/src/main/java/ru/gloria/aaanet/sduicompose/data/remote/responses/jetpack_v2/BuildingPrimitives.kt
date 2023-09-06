package ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2

import androidx.compose.foundation.layout.IntrinsicSize
import ru.gloria.aaanet.sduicompose.sound.Beep

enum class ElementType(val value: Int) {
    Button(0),
    IconButton(1),
    Container(2),
    Text(3),
    TextField(4),
    Divider(5),
    Spacer(6),
    Image(7),
    DatePicker(8),
    Spinner(9),
    ButtonOutLine(10),
    MultiSelector(11);

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}

enum class SignalType(val value: Int) {
    Success(0),
    Error(1),
    Warning(2);

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}

enum class DirectionType(val value: Int) {
    Vertical(0),
    Horizontal(1);

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}

enum class Icon(val value: Int) {
    Plus(0),
    Minus(1),
    Search(2),
    Burger(3),
    Column(4),
    Refresh(5),
    Back(6);

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}

enum class ClipShape {
    RectangleShape,
    CircleShape,
    RoundedCornerShape,
    CutCornerShape;
}

enum class TileMode {
    Clamp,
    Repeated,
    Mirror;
}

enum class GradientDirection {
    Horizontal,
    Vertical
}

enum class TextFieldKeyboardType {
    Ascii,
    Decimal,
    Email,
    Number,
    NumberPassword,
    Password,
    Phone,
    Text,
    Uri
}

data class ClickAction(
    val actionUri: String,
    val callbackData: BindingProperty
)

abstract class Composable {
    abstract val elementType: ElementType
    abstract val id: String
    abstract val clickAction: ClickAction?
    abstract val modifiers: List<Modifier>
}

data class Modifier(
    val weight: Float?,
    val width: Int?,
    val height: Int?,
    val fillMaxSize: Boolean?,
    val fillMaxWidth: Boolean?,
    val fillMaxHeight: Boolean?,
    val padding: Int?,
    val paddingVertical: Int?,
    val paddingHorizontal: Int?,
    val intrinsicSizeHeight: IntrinsicSize?,
    val intrinsicSizeWidth: IntrinsicSize?,
    val background: Background?,
    val border: Border?,
    val alpha: Float?,
    val clip: Shape?,
    val size: Int?,
    val offset: Offset?,
    val shadow: Shadow
)

class Container(
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
    val direction: DirectionType,
    val items: List<Composable>,
    val hasScroll: Boolean,
    val isCollapse: Boolean,
    val collapseButtonText: String,
    val collapseButtonColor: Color
) : Composable()

data class ScanAction(
    val actionUri: String,
    val callbackData: BindingProperty
)

data class Spacer(
    override val elementType: ElementType,
    override val id: String,
    override val clickAction: ClickAction?,
    override val modifiers: List<Modifier>
) : Composable()

data class Signal(
    val signalType: SignalType,
    val duration: Int,
    val repeatCount: Int
)

data class ModalDialog(
    val header: BindingProperty,
    val message: BindingProperty,
    var showModal: Boolean,
    val local: Boolean,
    val buttons: List<Button>
)

data class Screen(
    val items: List<Composable> = listOf(),
    val modalDialog: ModalDialog? = null,
    val scanAction: ScanAction? = null,
    val signal: Signal? = null,
    val header: Header? = null,
    val footer: Footer? = null,
    var dataContext: Any? = null
) {
    init {
        if (signal != null) {
            when (signal.signalType) {
                SignalType.Error -> Beep.beepError()
                SignalType.Success -> Beep.beepSuccess()
                SignalType.Warning -> Beep.beepWarning()
            }
        }
    }
}

data class BindingProperty(
    val value: String,
    val selfContained: Boolean
)

data class Offset(
    val x: Int,
    val y: Int
)

data class Text(
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
    val content: BindingProperty,
    val textAlign: Int,
    val fontSize: Int,
    val fontWeight: Int,
    val fontStyle: Int,
    val color: Color?
) : Composable()

data class TextField(
    override val elementType: ElementType,
    override val id: String,
    override val clickAction: ClickAction?,
    override val modifiers: List<Modifier>,
    val value: BindingProperty,
    val placeholder: BindingProperty?,
    val label: BindingProperty?,
    var singleLine: Boolean,
    var autoFocus: Boolean,
    val keyboardType: TextFieldKeyboardType
) : Composable()

data class Header(
    val contents: List<Composable>
)

data class Footer(
    val content: Composable,
    val buttons: List<IconButton>?
)

data class Background(
    val color: Color,
    val shape: Shape,
    val gradient: Gradient
)

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
)

data class Shape(
    val clipShape: ClipShape,
    val percent: Int
)

data class Border(
    val width: Int,
    val color: Color,
    val shape: Shape?
)

data class Gradient(
    val colors: List<Color>,
    val startX: Float,
    val endX: Float,
    val direction: GradientDirection,
    val tile: TileMode
)

data class Shadow(
    val elevation: Int,
    val shape: Shape
)

data class Button(
    val content: Composable,
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
) : Composable()

data class ButtonOutLine(
    val textField: TextField,
    val content: Composable,
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
) : Composable()

data class IconButton(
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
    val icon: Icon,
    val dropdownMenu: DropdownMenu
) : Composable()

data class Divider(
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
    val direction: DirectionType
) : Composable()

data class Image(
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
    val image: String,
    val url: BindingProperty?
) : Composable()

data class DatePicker(
    val textField: TextField,
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
) : Composable()

data class Spinner(
    val content: Text,
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
) : Composable()

data class DropdownMenu(
    val dropdownMenuItems: List<DropdownMenuItem>,
    val modifiers: List<Modifier>
)

data class DropdownMenuItem(
    val text: BindingProperty,
    val clickAction: ClickAction,
    val enabled: Boolean
)

data class MultiSelector(
    val statusList: List<String>,
    val labelStatus: Text,
    val selectedStatuses: BindingProperty,
    override val elementType: ElementType,
    override val clickAction: ClickAction?,
    override val id: String,
    override val modifiers: List<Modifier>,
) : Composable()