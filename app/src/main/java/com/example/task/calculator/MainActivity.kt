package com.example.task.calculator

import android.os.Bundle
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.calculator.ui.theme.TaskCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCalculatorTheme {
                // A surface container using the 'background' color from the theme
               mainScreen()
            }
        }
    }
}

@Composable
fun mainScreen(){
    Surface() {
        Column(modifier = Modifier.padding(24.dp )) {
            title()
            screen("0")
            buttonsBody()
        }
    }
}

@Composable
fun title() {
    Text(text = "Сalculator", Modifier.height(34.dp), style = TextStyle(fontSize = 28.sp))
}

@Composable
fun screen(number: String){
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
fun buttonsBody(){
    Row() {
        Column() {
            Row() {
                for (el in CalcScreen.calcFun) {
                    buttonsWhite(text = el.title)
                }
            }
            for (el in CalcScreen.numbers) {
                Row() {
                    for (el_num in el) {
                        buttonsWhite(text = el_num.title)
                    }
                }
            }
        }

        Column() {
            for (el in CalcScreen.mathOperations) {
                buttonsBlue(text = el.title)
            }
        }
    }
}

@Composable
fun buttonsWhite(text: String){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .size(80.dp),
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
fun buttonsBlue(text: String){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .size(80.dp),
        shape = RoundedCornerShape(20),
        colors =  ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
    ){
        Text(text = text, style = TextStyle(color = Color.Black, fontSize = 29.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCalculatorTheme {
        mainScreen()
    }
}