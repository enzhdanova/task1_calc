package com.example.task.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.calculator.component.ButtonCalc
import com.example.task.calculator.component.Display
import com.example.task.calculator.component.Title
import com.example.task.calculator.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCalculatorTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val str_zero = stringResource(id = R.string.zero_tmp)

    val result = remember {
        mutableStateOf(str_zero)
    }

    val nowNumber = remember {
        mutableStateOf("")
    }

    val mathOperation = remember {
        mutableStateOf(MathOperationEnum.Add)
    }

    val nextNewDigit = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .padding(top = 18.dp, start = 24.dp, end = 24.dp, bottom = 18.dp)
            .fillMaxSize()
    ) {
        Title(
            titleText = R.string.title_calculator,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .height(34.dp)
        )
        Display(
            number = nowNumber.value,
            modifier = Modifier.height(100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row()
        {
            Column(Modifier.weight(5.7f)) {
                SupportCalcOperation(modifier = Modifier.fillMaxWidth()) {
                    nowNumber.value = Calculator().getDisplayContent(nowNumber.value, it)
                    if (nowNumber.value == "") {
                        result.value = str_zero
                        mathOperation.value = MathOperationEnum.Add
                        nextNewDigit.value = true
                    }
                    nowNumber.value
                }
                Spacer(modifier = Modifier.size(15.dp))
                NumbersButton(modifier = Modifier.fillMaxWidth()) {
                    if (nextNewDigit.value) {
                        nextNewDigit.value = false
                        nowNumber.value = ""
                    }
                    nowNumber.value = Calculator().getNewNumber(nowNumber.value, it)
                    nowNumber.value
                }
                ZeroAndComma(modifier = Modifier.fillMaxWidth()) {
                    if (nextNewDigit.value) {
                        nextNewDigit.value = false
                        nowNumber.value = ""
                    }
                    nowNumber.value = Calculator().getNewNumber(nowNumber.value, it)
                    nowNumber.value
                }
            }
            MathOperation(modifier = Modifier.weight(1.6f)) {
                if (!nextNewDigit.value) {
                    nowNumber.value = Calculator()
                        .getResultMathOperation(
                            result.value,
                            nowNumber.value, mathOperation = mathOperation.value
                        )
                    result.value = nowNumber.value

                }
                nextNewDigit.value = true
                mathOperation.value = it
            }
        }
    }
}

@Composable
private fun MathOperation(modifier: Modifier, onClick: (MathOperationEnum) -> Unit) {
    Column(modifier = modifier.fillMaxWidth()) {
        for (el in MathOperationEnum.values()) {
            ButtonCalc(
                contentText = el.operation,
                modifier = Modifier
                    .aspectRatio(1f), ButtonDefaults
                    .buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.primary
                    )
            ) {
                onClick(el)
            }
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
private fun NumbersButton(modifier: Modifier, onClick: (String) -> String) {
    Column(modifier = modifier) {
        for (i in 7 downTo 1 step 3) {
            Row {
                for (j in i..(i + 2)) {
                    ButtonCalc(contentText = j.toString(),
                        modifier = Modifier
                            .weight(1.6f)
                            .aspectRatio(1f),
                        onClick = {
                            onClick(j.toString())
                        })
                    Spacer(modifier = Modifier.weight(0.3f))
                }
            }
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
private fun SupportCalcOperation(modifier: Modifier, onClick: (String) -> String) {
    Row(modifier = modifier) {
        for (el in SupportOperationEnum.values()) {
            ButtonCalc(
                contentText = el.operation,
                modifier = Modifier
                    .weight(1.6f)
                    .aspectRatio(1f)
            ) {
                onClick(el.operation)
            }
            Spacer(modifier = Modifier.weight(0.3f))
        }
    }
}

@Composable
private fun ZeroAndComma(modifier: Modifier, onClick: (String) -> String) {
    val zero = stringResource(R.string.button_zero)
    val comma = stringResource(R.string.button_comma)
    Row(modifier = modifier) {
        ButtonCalc(
            contentText = stringResource(R.string.button_zero),
            modifier = Modifier
                .weight(3.5f)
                .aspectRatio(2.1f)
        ) {
            onClick(zero)
        }
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(
            contentText = stringResource(R.string.button_comma),
            modifier = Modifier
                .weight(1.6f)
                .aspectRatio(1f)
        ) {
            onClick(comma)
        }
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TaskCalculatorTheme {
        MainScreen()
    }
}