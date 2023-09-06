package ru.gloria.aaanet.sduicompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.gloria.aaanet.sduicompose.R

// Set of Material typography styles to start with
val robotoFonts = FontFamily(
    Font(R.font.roboto_black, weight = FontWeight.W900),
    Font(R.font.roboto_black_italic, weight = FontWeight.W900, style = FontStyle.Italic),
    Font(R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.roboto_bold, weight = FontWeight.W700),
    Font(R.font.roboto_bold_italic, weight = FontWeight.W700, style = FontStyle.Italic),
    Font(R.font.roboto_light, weight = FontWeight.Light),
    Font(R.font.roboto_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.roboto_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.roboto_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.roboto_thin, weight = FontWeight.Thin),
    Font(R.font.roboto_thin, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(R.font.roboto_regular, weight = FontWeight.W400)

)

val Typography = Typography(
    defaultFontFamily = robotoFonts,
    body1 = TextStyle(
        fontFamily = robotoFonts,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    ),
    // Other default text styles to override
    h1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        fontSize = 8.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)