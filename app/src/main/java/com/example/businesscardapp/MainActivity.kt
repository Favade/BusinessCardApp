package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardMain()
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactInformation(
            logo =  Icons.Filled.Phone,
            modifier = Modifier.padding(end = 5.dp) ,
            info = "111-222-3333"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ContactInformation(
            logo = Icons.Filled.PlayArrow,
            modifier = Modifier.padding(end = 25.dp) ,
            info =  "@zero"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ContactInformation(
            logo = Icons.Filled.Check,
            info = "zfav@gmail.com"
        )
        Spacer(modifier = Modifier.height(50.dp))
    }


}

@Composable
fun CardMain() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo__1_),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Text(
            text = "Favour",
            fontSize = 32.sp,
            color = Color.White
        )
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Text(
            text = "Android Jetpack Compose Trainee",
            fontWeight = FontWeight.Bold,
            color  = Color(0xFF3ddc84)
        )
    }
}



@Composable
fun ContactInformation(
    logo: ImageVector,
    info: String,
    modifier: Modifier = Modifier
) {
    Divider(
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    )
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                logo,
                contentDescription = null,
            )
        }
        Text(
            text = info,
            color = Color(0xFF3ddc84)
        )

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}