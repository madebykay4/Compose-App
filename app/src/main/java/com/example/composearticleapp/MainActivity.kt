package com.example.composearticleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticleapp.ui.theme.ComposeArticleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InformationImage(
                        title = stringResource(R.string.title),
                        short = stringResource(R.string.short_text),
                        long = stringResource(R.string.long_text),
                        image = painterResource(R.drawable.compaseappimg),
                    )
                }
            }
        }
    }
}

@Composable
fun InformationImage(title: String, short: String, long: String, image:Painter, modifier: Modifier = Modifier) {
    val image: Painter = painterResource(R.drawable.compaseappimg)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Information(
            title = title,
            short = short,
            long = long,
            modifier = Modifier.padding(0.dp, 130.dp, 0.dp, 0.dp)
            )
    }
}


    @Composable
    fun Information(
        title: String,
        short: String,
        long: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                /*lineHeight = 90.sp,
                textAlign = TextAlign.Left,*/
                modifier = Modifier.padding(16.dp,16.dp,16.dp,16.dp)
            )

            Text(
                text = short,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp)
            )

            Text(
                text = long,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp,16.dp,16.dp,16.dp)

            )

        }

    }

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    ComposeArticleAppTheme { InformationImage(title = stringResource(R.string.title), short = stringResource(R.string.short_text), long = stringResource(R.string.long_text), image = painterResource(R.drawable.compaseappimg))
    }
}