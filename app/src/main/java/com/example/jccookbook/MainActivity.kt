package com.example.jccookbook

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jccookbook.ui.theme.JcCookBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JcCookBookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CookPage()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookPage() {

    Scaffold(
        topBar = {
                 TopAppBar(
                     title = { CookStr(content = "Cook Recipe")},
                     colors = TopAppBarDefaults.smallTopAppBarColors(
                         containerColor = colorResource(id = R.color.mainColor)
                     )
                 )
        },
        content = {

            Column(
                    modifier = Modifier
                            .fillMaxSize()
                            .padding(1.dp, 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                        painter = painterResource(id = R.drawable.samplecook),
                        contentDescription = "Chicken Salad"
                )
                Row(
                        modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = { Log.e("LikeButton","Cook is liked") },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.anotherColor)
                            ),
                            modifier = Modifier.weight(50f)
                    ) {
                        CookStr(content = "Like")
                    }

                    Button(onClick = { Log.e("CommentButton","Commented") },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.anotherColor)
                            ),
                            modifier = Modifier.weight(50f)
                    ) {
                        CookStr(content = "Comment")
                    }

                }

                Column(
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 10.dp)
                ) {
                    Text(text = "Chicken Salad",
                            color = colorResource(id = R.color.anotherColor),
                            fontSize = 18.sp)

                    Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CookStr(content = "Suitable for grilling")
                        CookStr(content = "22 August")
                    }
                }

                Text(text = stringResource(id = R.string.cook_recipe),
                        modifier = Modifier.padding(all = 10.dp),
                        textAlign = TextAlign.Center)
            }

        }
    )
}

@Composable
fun CookStr(content:String) {
    Text(text = content)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JcCookBookTheme {
        CookPage()
    }
}