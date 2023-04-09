package com.fuwafuwa.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fuwafuwa.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComponentQuadrant()
                }
            }
        }
    }
}

@Composable
fun OneQuadrant(title:String,content:String,color:Color,modifier: Modifier=Modifier){
    Column(modifier= modifier.fillMaxSize()
        .padding(16.dp)
        .background(color),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom=16.dp))
        Text(text = content, textAlign = TextAlign.Justify)
    }

}

@Composable
fun ComponentQuadrant(modifier: Modifier = Modifier) {
    Column(modifier=modifier){
        Row(Modifier.weight(1f)){
            OneQuadrant(
                title = stringResource(id = R.string.green_title),
                content = stringResource(id = R.string.green_content) ,
                color = Color.Green,
                modifier = Modifier.weight(1f))
            OneQuadrant(
                title = stringResource(id = R.string.yellow_title),
                content = stringResource(id = R.string.yellow_content) ,
                color = Color.Yellow,
                modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)){
            OneQuadrant(
                title = stringResource(id = R.string.sky_title),
                content = stringResource(id = R.string.sky_content) ,
                color = Color.Blue,
                modifier = Modifier.weight(1f))
            OneQuadrant(
                title = stringResource(id = R.string.gray_title),
                content = stringResource(id = R.string.gray_content) ,
                color = Color.LightGray,
                modifier = Modifier.weight(1f))
        }


    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComponentQuadrant()
    }
}