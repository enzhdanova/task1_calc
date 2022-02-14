package com.example.task.calculator.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.calculator.ui.theme.BackgroundNumberColor
import com.example.task.calculator.R
import com.example.task.calculator.ui.theme.TaskCalculatorTheme

@Composable
fun Display(number: String, modifier: Modifier){
    Box(modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.rectangle_calc),
            contentDescription = "numbers",
            modifier = Modifier.fillMaxSize())
        Text(
            text = stringResource(R.string.backgroundText),
            style = MaterialTheme.typography.caption,
            color = BackgroundNumberColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp)
                .height(44.dp),
            maxLines = 1)
        Text(
            text = number,  style = MaterialTheme.typography.caption,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp)
                .height(44.dp),
            maxLines = 1)
    }
}

@Preview
@Composable
private fun displayCalcPreview() {
    TaskCalculatorTheme {
        Surface(Modifier.width(366.dp)) {
            Display(number = stringResource(id = R.string.button_zero), Modifier.height(100.dp).fillMaxWidth())
        }
    }
}

