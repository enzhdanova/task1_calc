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
private fun MainScreen(){
    val calcState = remember {
        mutableStateOf(CalcState("0","", "+"))
    }

    Column(modifier = Modifier
        .padding(top = 18.dp, start = 24.dp, end = 24.dp, bottom = 18.dp)
        .fillMaxSize()) {
        Title(titleText = R.string.title_calculator, Modifier.padding(bottom = 15.dp).height(34.dp))
        Display(calcState.value.tmp, Modifier.fillMaxWidth().height(100.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Row()
        {
            Column(Modifier.weight(5.7f)) {
                CalcOperation(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.size(15.dp))
                NumbersButton(modifier = Modifier.fillMaxWidth())
                ZeroAndComma(modifier = Modifier.fillMaxWidth())
            }
            MathOperation(modifier = Modifier.weight(1.6f))
        }
    }
}

@Composable
private fun MathOperation(modifier: Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        for (el in MathOperationConst.values()){
            ButtonCalc(contentText = el.operation,
                Modifier
                    .aspectRatio(1f),  MaterialTheme.colors.secondary,
                MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
private fun NumbersButton(modifier: Modifier){
    Column(modifier = modifier) {
        for (i in 7 downTo 1 step 3) {
            Row {
                for (j in i..(i+2)){
                    ButtonCalc(contentText = j.toString(),
                        Modifier
                            .weight(1.6f)
                            .aspectRatio(1f),
                        MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
                    Spacer(modifier = Modifier.weight(0.3f))
                }
            }
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
private fun CalcOperation(modifier: Modifier){
    Row(modifier = modifier){
        ButtonCalc(contentText = stringResource(R.string.button_ac),
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(contentText = stringResource(R.string.button_sign),
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(contentText = stringResource(R.string.button_percent),
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Composable
private fun ZeroAndComma(modifier: Modifier){
    Row(modifier = modifier){
        ButtonCalc(contentText = stringResource(R.string.button_zero),
            Modifier
                .weight(3.5f)
                .aspectRatio(2.1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(contentText = stringResource(R.string.button_comma),
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
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