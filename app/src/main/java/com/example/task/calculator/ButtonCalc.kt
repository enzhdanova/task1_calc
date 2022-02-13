package com.example.task.calculator

import android.text.Layout
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.calculator.ui.theme.ButtonFont
import com.example.task.calculator.ui.theme.ButtonOperation
import com.example.task.calculator.ui.theme.TaskCalculatorTheme

@Composable
fun ButtonCalc(text: String, modifier: Modifier, backgroundColor: Color, textColor: Color){
    Button(onClick = {},
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(backgroundColor),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ){
        Text(text = text, style = TextStyle(color = textColor, fontSize = 29.sp, fontFamily = ButtonFont))
    }
}
