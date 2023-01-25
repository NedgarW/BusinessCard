package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard(
                        name = stringResource(R.string.name),
                        status = stringResource(R.string.status),
                        mobileNumber = stringResource(R.string.mobileNumber),
                        email = stringResource(R.string.email),
                        socialNetwork = stringResource(R.string.socialNetwork)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    status: String,
    mobileNumber: String,
    email: String,
    socialNetwork: String
) {
    val imageAndroid = painterResource(R.drawable.android_logo)
    val imageMobile = painterResource(R.drawable.mobilr)
    val imageSocialNetwork =
        painterResource(R.drawable.png_clipart_social_media_computer_icons_share_icon_social_networking_service_icon_design_social_media_social_media_desktop_wallpaper)
    val imageEmail = painterResource(R.drawable.apple_mail)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.blue56)),
        verticalArrangement = Arrangement.Center,
    ) {


        Image(
            painter = imageAndroid, contentDescription = null,
            modifier = Modifier
                .requiredSize(150.dp)
                .align(Alignment.CenterHorizontally)

        )

        Text(
            text = name, color = Color.White, modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = status, color = colorResource(R.color.green676), modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 25.dp, start = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row() {
            Image(
                painter = imageMobile, contentDescription = null,
                modifier = Modifier
                    .requiredSize(30.dp)
                    .padding(bottom = 8.dp)
            )
            Text(text = mobileNumber, modifier = Modifier.padding(start = 8.dp))
        }
        Row() {
            Image(
                painter = imageSocialNetwork, contentDescription = null,
                modifier = Modifier
                    .requiredSize(30.dp)
                    .padding(bottom = 8.dp)
            )
            Text(text = socialNetwork, modifier = Modifier.padding(start = 8.dp))
        }


        Row {
            Image(
                painter = imageEmail, contentDescription = null,
                modifier = Modifier
                    .requiredSize(30.dp)
                    .padding(bottom = 8.dp)
            )
            Text(text = email, modifier = Modifier.padding(start = 8.dp))
        }

    }

}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    BusinessCard(
        name = stringResource(R.string.name),
        status = stringResource(R.string.status),
        mobileNumber = stringResource(R.string.mobileNumber),
        email = stringResource(R.string.email),
        socialNetwork = stringResource(R.string.socialNetwork)
    )
}