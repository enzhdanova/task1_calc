package com.example.task.calculator.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.task.calculator.R

val DigitalFont = FontFamily(
        Font(R.font.digital__mono)
)

val TitleFont = FontFamily(
        Font(R.font.museo_regular)
)

val ButtonFont = FontFamily(
        Font(R.font.montserrat_regular)
)
// Set of Material typography styles to start with
val Typography = Typography(
        body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ),
        body2 = TextStyle(
                fontFamily = DigitalFont,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        )

/* Other default text styles to override
button = TextStyle(
fontFamily = FontFamily.Default,
fontWeight = FontWeight.W500,
fontSize = 14.sp
),
caption = TextStyle(
fontFamily = FontFamily.Default,
fontWeight = FontWeight.Normal,
fontSize = 12.sp
)
*/
)

