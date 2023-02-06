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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
            color = colorResource(id = R.color.colorBackground),
            shape = RoundedCornerShape(32.dp, 32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.note_logo_3),
                    contentDescription = "logo",
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    text = "Journal",
                    fontFamily = FontFamily(Font(R.font.playfair_display_regular)),
                    fontSize = 40.sp
                )
                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = stringResource(id = R.string.about_me),
                    textAlign = TextAlign.Center,
                    color = colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp,0.dp),
                    fontFamily = FontFamily(Font(R.font.playfair_display_regular))
                )
                Spacer(modifier = Modifier.height(100.dp))
                Button(
                    onClick = { startActivity(context, intentGithub, null)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White),
                    shape = RoundedCornerShape(20.dp),

                    ) {
                        Text(
                            text = "GitHub",
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.playfair_display_regular)),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { startActivity(context, intentLinkedIn, null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.linked_in_btn),
                        contentColor = Color.White),
                    shape = RoundedCornerShape(20.dp),
                    ) {
                        Text(
                            text = "LinkedIn",
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.playfair_display_regular)),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}