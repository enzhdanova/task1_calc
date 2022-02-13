package com.example.task.calculator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Text(text = text, style = MaterialTheme.typography.button, color = textColor)
    }
}

@Preview
@Composable
fun ButtonCalcPreview() {
    TaskCalculatorTheme {
        ButtonCalc(text = stringResource(id = R.string.button_zero),
            modifier = Modifier.size(80.dp),
            backgroundColor = MaterialTheme.colors.primary,
            textColor = MaterialTheme.colors.secondary)
    }
}