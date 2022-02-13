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
fun Title() {
    Text(text = "Calculator",
        Modifier
            .padding(bottom = 15.dp)
            .height(34.dp), style = TextStyle(fontSize = 28.sp, fontFamily = TitleFont))
}

@Composable
fun Screen(number: String){
    val backgroundText = "8888888888888"

    Box(modifier = Modifier
        .height(height = 100.dp)
        .fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.rectangle_calc),
            contentDescription = "numbers",
            modifier = Modifier.fillMaxSize())
        Text(
            text = backgroundText,
            style = TextStyle(fontSize = 52.sp, fontFamily = DigitalFont),
            color = BackgroundNumberColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp)
                .height(44.dp),
            maxLines = 1)
        Text(
            text = number,  style = TextStyle(fontSize = 52.sp, fontFamily = DigitalFont),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 22.dp, end = 22.dp)
                .height(44.dp),
            maxLines = 1)
    }
}

@Composable
fun MathOperation(modifier: Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        for (el in CalcScreen.mathOperations){
            ButtonCalc(text = el,
                Modifier
                    .aspectRatio(1f),  MaterialTheme.colors.secondary, MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}


@Composable
fun NumbersButton(modifier: Modifier){
    Column(modifier = modifier) {
        for (i in 7 downTo 1 step 3) {
            Row {
                for (j in i..(i+2)){
                    ButtonCalc(text = j.toString(),
                        Modifier
                            .weight(1.6f)
                            .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
                    Spacer(modifier = Modifier.weight(0.3f))
                }
            }
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
fun CalcOperation(modifier: Modifier){
    Row(modifier = modifier){
        ButtonCalc(text = "AC",
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(text = "+/-",
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(text = "%",
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
    }

}

@Composable
fun ZeroAndComma(modifier: Modifier){
    Row(modifier = modifier){
        ButtonCalc(text = "0",
            Modifier
                .weight(3.5f)
                .aspectRatio(2.1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
        ButtonCalc(text = ",",
            Modifier
                .weight(1.6f)
                .aspectRatio(1f), MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCalculatorTheme {
        MainScreen()
    }
}