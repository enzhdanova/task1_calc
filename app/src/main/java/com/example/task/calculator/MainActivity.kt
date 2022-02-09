package com.example.task.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.calculator.ui.theme.TaskCalculatorTheme

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
fun MainScreen(){

    var currentValue = remember { mutableStateOf("0") }
    var calcState = remember {
        mutableStateOf(CalcState("0","", "+"))
    }

    Column(modifier = Modifier
        .padding(top = 18.dp, start = 24.dp, end = 24.dp, bottom = 18.dp)
        .fillMaxSize()) {
        Title()
        Screen(calcState.value.tmp)
        Spacer(modifier = Modifier.height(20.dp))
        //buttons
        Row {
            Column{
                OperationButtonGroup()
                Spacer(modifier = Modifier.height(15.dp))
                NumbersButton {
                    var tmp = calcState.value.tmp
                    if (tmp == "" || tmp == "0") {
                        tmp = it
                    } else {
                        tmp +=it
                    }
                    calcState.value = calcState.value.copy(tmp = tmp)
                }
            }
            Column {
                MathOperation {
                    var result = calcState.value.result
                    if (calcState.value.tmp != ""){
                        result = getResultMathOperation(
                            calcState.value.result,
                            calcState.value.tmp,
                            calcState.value.mathOperation
                        )
                        println("$result  $it")
                    }
                        val calcStateTmp =
                            checkAndReturnResult(nowMathOperation = it, result = result)
                        println(calcStateTmp)
                        calcState.value = calcState.value.copy(
                            tmp = calcStateTmp.tmp,
                            result = calcStateTmp.result,
                            mathOperation = calcStateTmp.mathOperation
                        )
                        println(calcState)


                }
            }
        }
    }

}

@Composable
fun Title() {
    Text(text = "Calculator",
        Modifier
            .padding(bottom = 15.dp)
            .height(34.dp), style = TextStyle(fontSize = 28.sp))
}

@Composable
fun Screen(number: String){
    Box(modifier = Modifier
        .size(width = 366.dp, height = 100.dp)) {
        Image(painter = painterResource(id = R.drawable.rectangle_calc),
            contentDescription = "numbers",
            modifier = Modifier.fillMaxSize())
        Text(
            text = number,  style = TextStyle(fontSize = 40.sp),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp))
    }
}


@Composable
fun MathOperation(mattOp: (String) -> Unit){
    Column(modifier = Modifier
        .width(80.dp)
        ) {
        for (el in CalcScreen.mathOperations){
            ButtonsBlue(text = el.title, mattOp)
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
fun OperationButtonGroup(){
    var size = 80.dp
    Row {
        for (caclFun in CalcScreen.calcFun) {

            ButtonsWhite(text = caclFun.title, size, {})
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

@Composable
fun NumbersButton(printNumber: (String) -> Unit){
   var size: Dp
   for (el_num in CalcScreen.numbers) {
       Row {
           for (el in el_num ){
               size = if (el.title == "0") {
                   175.dp
               } else {
                   80.dp
               }
               ButtonsWhite(text = el.title, size, printNumber)
               Spacer(modifier = Modifier.width(15.dp))
           }
       }
       Spacer(modifier = Modifier.height(15.dp))
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCalculatorTheme {
        MainScreen()
    }
}