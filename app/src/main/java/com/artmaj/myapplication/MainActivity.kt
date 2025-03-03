package com.artmaj.myapplication

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artmaj.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val someBook = Book("Lord of the Rings", "Tolkien", BookCondition.USED)
        val theSameBook = Book("Lord of the Rings", "Tolkien", BookCondition.USED)

        val bookND1 = BookNonData("LOTR", "Tolkien", BookCondition.NEW)

        val bookND2 = BookNonData("LOTR", "Tolkien", BookCondition.NEW)
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        Greeting(
                            name = "" + someBook.title +
                                    ", is theSame = " + (someBook == theSameBook),
                            modifier = Modifier.padding(innerPadding)
                        )
                        Greeting(
                            name = "" + bookND1.title +
                                    ", is theSame = " + (bookND1 == bookND2),
                            modifier = Modifier.padding(innerPadding)
                        )
                        for(i in 0..20)
                            SomeLayout(
                                name = "" + bookND1.title +
                                        ", is theSame = " + (bookND1 == bookND2),
                                modifier = Modifier.padding(PaddingValues(top = 15.dp, bottom = 15.dp,
                                    start = 10.dp, end = 10.dp))
                            )
                    }
                }
            }
        }
    }


    fun getMedian(values: List<Int>): Float {
        return if (values.size % 2 == 1)
            (values.sorted()[(values.size - 1) / 2]).toFloat()
        else
            ((values.sorted()[values.size / 2] + values.sorted()[values.size / 2 - 1]) / 2.0f)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SomeLayout(name: String, modifier: Modifier = Modifier) {
    Column() {

        Row(modifier = Modifier.background(Color.Cyan).fillMaxWidth(1.0f), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Dupa $name!",
                modifier = modifier
            )
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(Color(200,240,200)))

        }
        HorizontalDivider(thickness = 1.dp, color = Color.Red)
    }
}
@Preview(showBackground = true)
@Composable
fun SomeLayoutPreview() {
    MyApplicationTheme {
        SomeLayout("Android")
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}