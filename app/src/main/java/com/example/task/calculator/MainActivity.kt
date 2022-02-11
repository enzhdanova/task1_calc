package com.example.task.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun MainScreen(){
    val calcState = remember {
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
                Row {
                    ButtonsWhite(text = "AC", 80.dp) {
                        calcState.value =
                            calcState.value.copy(tmp = "", result = "0", mathOperation = "+")
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    ButtonsWhite(text = "+/-", 80.dp){
                        val tmp = calcState.value.changeSign()
                        calcState.value = calcState.value.copy(tmp = tmp)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    ButtonsWhite(text = "%", 80.dp) {
                        val tmp = calcState.value.tmp.toDouble()/100
                        calcState.value =
                            calcState.value.copy(tmp = tmp.toString(), result = "0", mathOperation = "+")
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                }
                Spacer(modifier = Modifier.height(15.dp))
                NumbersButton {
                    calcState.value = calcState.value.copy(tmp = calcState.value.getNewNumber(it))
                }
            }
            Column {
                MathOperation {
                    var result = calcState.value.result
                    if (calcState.value.tmp != ""){
                        result = calcState.value.getResultMathOperation()
                    }
                    calcState.value =
                            calcState.value.returnResultCalcState(nowMathOperation = it, result = result)
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
            .height(34.dp), style = TextStyle(fontSize = 28.sp, fontFamily = TitleFont))
}

@Composable
fun Screen(number: String){
    var backgroundText = "8888888888888"
    // это сделано для того, чтобы нижний текст тоже скролился и соответствовал при наложении тексту сверху
    while (backgroundText.length < number.length){
        backgroundText +="8"
    }

    val scroll = rememberScrollState(0)
    Box(modifier = Modifier
        .size(width = 366.dp, height = 100.dp)) {
        Image(painter = painterResource(id = R.drawable.rectangle_calc),
            contentDescription = "numbers",
            modifier = Modifier.fillMaxSize())
        Text(
            text = backgroundText,  style = TextStyle(fontSize = 52.sp, fontFamily = DigitalFont), color = BackgroundNumberColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp)
                .height(44.dp).horizontalScroll(state = scroll),
            maxLines = 1)
        Text(
            text = number,  style = TextStyle(fontSize = 52.sp, fontFamily = DigitalFont),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp)
                .height(44.dp).horizontalScroll(scroll),
            maxLines = 1)
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