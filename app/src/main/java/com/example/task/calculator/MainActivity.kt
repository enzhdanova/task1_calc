package com.example.task.calculator

import android.os.Bundle
import android.text.style.LineHeightSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                // A surface container using the 'background' color from the theme
               MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    Surface() {
        Column(modifier = Modifier.padding(top = 20.dp, start = 24.dp, end = 24.dp, bottom = 20.dp)
            .width(366.dp)
            .fillMaxHeight()) {
            Title()
            Screen("0")
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween) {
            ButtonsBody()
            }
        }
    }
}

@Composable
fun Title() {
    Text(text = "Сalculator", Modifier.padding(bottom = 20.dp).height(34.dp), style = TextStyle(fontSize = 28.sp))
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
fun ButtonsBody(){
    var size = 80.dp
    Row(modifier = Modifier.padding(top = 25.dp).fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement  =  Arrangement.SpaceBetween) {
        for (el in CalcScreen.calcFun) {
            ButtonsWhite(text = el.title, size)
        }
        val el = CalcScreen.mathOperations[0]
        ButtonsBlue(text = el.title)
    }

    var index = 1
    for (el in CalcScreen.numbers) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement  =  Arrangement.SpaceBetween) {
            for (el_num in el) {

                if (el_num.title.equals("0")) {
                    size = 175.dp
                } else { size = 80.dp}
                ButtonsWhite(text = el_num.title, size)
            }
            val el = CalcScreen.mathOperations[index]
            ButtonsBlue(text = el.title)
            index++
        }
    }
}

@Composable
fun ButtonsWhite(text: String, height: Dp){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.width(height).height(80.dp),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCalculatorTheme {
        MainScreen()
    }
}