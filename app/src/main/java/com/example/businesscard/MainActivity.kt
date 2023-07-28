package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard()
{
    Column (
        modifier = Modifier.fillMaxSize().background(Color(0xFFCAE9D4)),
        verticalArrangement = Arrangement.SpaceAround
    ){
        BusinessCardInfo(
            name = stringResource(R.string.business_owner),
            title = stringResource(R.string.business_name)
        )
        BusinessContactInfo(
            phone = stringResource(R.string.phone_number),
            social = stringResource(R.string.share_text),
            email = stringResource(R.string.email_text)
        )
    }
}

@Composable
fun BusinessCardInfo(name: String, title: String) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.height(150.dp).width(150.dp).background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 35.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F7E4F)
        )
    }
}

@Composable
fun BusinessContactInfo(phone: String, social: String, email: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        BusinessContactLine(
            icon = painterResource(R.drawable.baseline_local_phone_24),
            message = phone
        )
        BusinessContactLine(
            icon = painterResource(R.drawable.baseline_share_24),
            message = social
        )
        BusinessContactLine(
            icon = painterResource(R.drawable.baseline_email_24),
            message = email
        )
    }
}

@Composable
fun BusinessContactLine(icon: Painter, message: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color(0xFF1F7E4F),
            modifier = Modifier.padding(start = 60.dp, end = 8.dp)
        )
        Text(
            text = message,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
