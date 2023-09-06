package ru.gloria.aaanet.sduicompose.adapters.jetpack_v2

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import ru.gloria.aaanet.sduicompose.data.remote.responses.jetpack_v2.*
import java.lang.reflect.Type

class IconIntDeserializer : JsonDeserializer<Icon> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Icon {
        return Icon.fromInt(json.asInt)
    }

}

class SignalIntDeserializer : JsonDeserializer<SignalType> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): SignalType {
        return SignalType.fromInt(json.asInt)
    }

}

class DirectionIntDeserializer : JsonDeserializer<DirectionType> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): DirectionType {
        return DirectionType.fromInt(json.asInt)
    }

}

class ElementTypeIntDeserializer : JsonDeserializer<ElementType> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ElementType {
        return ElementType.fromInt(json.asInt)
    }

}

class ComposableDeserializer : JsonDeserializer<Composable> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Composable {
        return mapElement(json, context)
    }
}

class JetpackDeserializer : JsonDeserializer<Screen> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Screen {

        if (json != null && context != null) {

            val jObject = json.asJsonObject

            val dataContext = context.deserialize<Any>(jObject["dataContext"], Any::class.java)

            var modalDialog: ModalDialog? = null

            if (jObject.has("modalDialog")) {
                modalDialog = context.deserialize(jObject["modalDialog"], ModalDialog::class.java)
            }

            var scanAction: ScanAction? = null

            if (jObject.has("scanAction")) {
                scanAction = context.deserialize(jObject["scanAction"], ScanAction::class.java)
            }

            var signal: Signal? = null

            if (jObject.has("signal")) {
                signal = context.deserialize(jObject["signal"], Signal::class.java)
            }

            val items: List<Composable> = jObject["items"].asJsonArray.map {
                mapElement(it, context)
            }

            var header: Header? = null

            if (jObject.has("header")) {
                header = context.deserialize<Header>(jObject["header"], Header::class.java)
            }

            var footer: Footer? = null

            if (jObject.has("footer")) {
                footer = context.deserialize<Footer>(jObject["footer"], Footer::class.java)
            }

            return Screen(
                dataContext = dataContext,
                modalDialog = modalDialog,
                scanAction = scanAction,
                signal = signal,
                items = items,
                header = header,
                footer = footer
            )
        } else {
            return Screen()
        }
    }
}

private fun mapElement(
    json: JsonElement,
    context: JsonDeserializationContext
): Composable {
    return when (ElementType.fromInt(json.asJsonObject["elementType"].asInt)) {
        ElementType.Text -> context.deserialize<Text>(json, Text::class.java)
        ElementType.TextField -> context.deserialize<TextField>(json, TextField::class.java)
        ElementType.Button -> context.deserialize<Button>(json, Button::class.java)
        ElementType.ButtonOutLine -> context.deserialize<ButtonOutLine>(
            json,
            ButtonOutLine::class.java
        )
        ElementType.IconButton -> context.deserialize<IconButton>(json, IconButton::class.java)
        ElementType.Container -> mapContainer(json, context)
        ElementType.Divider -> context.deserialize<Divider>(json, Divider::class.java)
        ElementType.Spacer -> context.deserialize<Spacer>(json, Spacer::class.java)
        ElementType.Image -> context.deserialize<Image>(json, Image::class.java)
        ElementType.DatePicker -> context.deserialize<DatePicker>(json, DatePicker::class.java)
        ElementType.Spinner -> context.deserialize<Spinner>(json, Spinner::class.java)
        ElementType.MultiSelector -> context.deserialize<MultiSelector>(json, MultiSelector::class.java)
    }
}

private fun mapContainer(
    json: JsonElement,
    context: JsonDeserializationContext
): Container {

    val jObject = json.asJsonObject

    val items: List<Composable> = jObject["items"].asJsonArray.map {
        mapElement(it, context)
    }

    val direction = DirectionType.fromInt(jObject["direction"].asInt)
    val id = jObject["id"].asString
    val elementType = ElementType.fromInt(jObject["elementType"].asInt)
    val hasScroll = jObject["hasScroll"].asBoolean
    val isCollapse = jObject["collapse"].asBoolean
    val collapseButtonText = jObject["collapseButtonText"].asString

    var clickAction: ClickAction? = null

    if (jObject.has("clickAction")) {
        clickAction =
            context.deserialize<ClickAction>(jObject["clickAction"], ClickAction::class.java)
    }

    var collapseButtonColor =
        context.deserialize<Color>(jObject["collapseButtonColor"], Color::class.java)

    var modifier: List<Modifier> = listOf()

    if (jObject.has("modifiers")) {
        modifier = jObject["modifiers"].asJsonArray.map {
            context.deserialize(it, Modifier::class.java)
        }
    }

    return Container(
        items = items,
        elementType = elementType,
        direction = direction,
        id = id,
        hasScroll = hasScroll,
        clickAction = clickAction,
        modifiers = modifier,
        isCollapse = isCollapse,
        collapseButtonText = collapseButtonText,
        collapseButtonColor = collapseButtonColor
    )
}