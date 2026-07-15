package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
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

        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFF0F2027),
                        Color(0xFF203A43),
                        Color(0xFF2C5364)
                    )
                )
            ),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {

        // Profile Picture
        Image(

            painter = painterResource(
                id = R.drawable.profile_photo
            ),

            contentDescription = "Profile Photo",

            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = Color(0xFF2E7D32),
                    shape = CircleShape
                )

        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(

            text = "Rainier Jefferson R. Amparo",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = Color.White

        )

        Text(

            text = "BSIT STUDENT 3rd year",

            fontSize = 18.sp,

            color = Color.White

        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        ContactRow(

            icon = "☎",

            text = "+63 9533 610 557"

        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        ContactRow(

            icon = "✉",

            text = "rjamparo61386@licoe.edu.ph"

        )

    }

}

@Composable
fun ContactRow(

    icon: String,

    text: String

) {

    Row(

        modifier = Modifier
            .clickable {

                // action placeholder

            },

        verticalAlignment = Alignment.CenterVertically

    ) {

        Text(

            text = icon,

            fontSize = 28.sp,

            color = Color(0xFFFFD54F)

        )

        Spacer(

            modifier = Modifier.width(12.dp)

        )

        Text(

            text = text,

            fontSize = 18.sp

        )

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun BusinessCardPreview() {

    MaterialTheme {

        BusinessCard()

    }

}