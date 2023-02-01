package com.swancompany.journal.ui.presentation.aboutScreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.swancompany.journal.R

@Composable
fun AboutScreen(
    navigateBack: () -> Unit,
) {
    val context = LocalContext.current
    val intentGithub = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sushilgitter/Journal"))
    val intentLinkedIn = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kmrsushil10/"))

    Scaffold(
        topBar = { AboutTopBar(navigateBack) },
        backgroundColor = colorScheme.surface
    ) {
        Surface(
            color = colorScheme.background,
            shape = RoundedCornerShape(32.dp, 32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(100.dp))
                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(160.dp),
                    shape = CircleShape,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier.background(colorScheme.secondaryContainer)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    text = "Journal",
                    fontFamily = FontFamily(Font(R.font.playfair_display_regular)),
                    fontSize = 40.sp
                )
                Text(
                    text = "Sushil Kumar",
                    color = colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth()
                        .alpha(0.8f)
                        .padding(start = 180.dp),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.dancing_script_regular))
                )

                Spacer(modifier = Modifier.height(160.dp))
                Button(
                    onClick = { startActivity(context, intentGithub, null)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White),
                    shape = RoundedCornerShape(50.dp, 50.dp, 0.dp,0.dp),
                    border = BorderStroke(1.dp, Color.White),

                    ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.github),
                            contentDescription = "git",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                        )
                        Text(
                            text = "GitHub",
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.assistant_regular)),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = { startActivity(context, intentLinkedIn, null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White),
                    shape = RoundedCornerShape(0.dp, 0.dp, 50.dp,50.dp),
                    border = BorderStroke(1.dp, Color.White),
                    ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.linkedin),
                            contentDescription = "git",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                        )
                        Text(
                            text = "LinkedIn",
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.assistant_regular)),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}