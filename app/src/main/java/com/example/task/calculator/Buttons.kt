package com.example.task.calculator

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonsWhite(text: String, height: Dp, funCalc: (String) -> Unit){
    Button(onClick = {funCalc(text)
        println("text  ${text}")},
        modifier = Modifier
            .width(height)
            .height(80.dp),
        shape = RoundedCornerShape(20),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ){
        Text(text = text, style = TextStyle(color = Color.Black, fontSize = 29.sp))
    }
}

@Composable
fun ButtonsBlue(text: String){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .size(80.dp),
        shape = RoundedCornerShape(20),
        colors =  ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ){
        Text(text = text, style = TextStyle(color = Color.Black, fontSize = 29.sp))
    }
}