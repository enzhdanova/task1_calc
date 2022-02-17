package com.example.task.calculator.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.calculator.R
import com.example.task.calculator.ui.theme.TaskCalculatorTheme

@Composable
fun ButtonCalc(
    contentText: String, modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults
        .buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.secondary
        ),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(20),
        colors = buttonColors,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp,
        ),

        ) {
        Text(text = contentText, style = MaterialTheme.typography.button)
    }
}

@Preview
@Composable
private fun ButtonCalcPreview() {
    TaskCalculatorTheme {
        ButtonCalc(contentText = stringResource(id = R.string.button_zero), onClick = {})
    }
}