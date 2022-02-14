package com.example.task.calculator.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.calculator.R
import com.example.task.calculator.ui.theme.TaskCalculatorTheme

@Composable
fun Title(@StringRes titleText: Int, modifier: Modifier) {
    Text(text = stringResource(id = titleText),
        modifier = modifier, style = MaterialTheme.typography.h1)
}

@Preview
@Composable
private fun TitlePreview(){
    TaskCalculatorTheme {
        Title(titleText = R.string.title_calculator, Modifier.padding(bottom = 15.dp).height(34.dp))
    }
}


