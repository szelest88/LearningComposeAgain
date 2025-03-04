package com.artmaj.myapplication

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artmaj.myapplication.ui.theme.MyApplicationTheme

val connection = CollapsingAppBarNestedScrollConnection() //initialing nestedScrollConnection here



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val someBook = Book("Lord of the Rings", "Tolkien", BookCondition.USED)
        val theSameBook = Book("Lord of the Rings", "Tolkien", BookCondition.USED)

        val bookND1 = BookNonData("LOTR", "Tolkien", BookCondition.NEW)

        val bookND2 = BookNonData("LOTR", "Tolkien", BookCondition.NEW)
        setContent {
            MyApplicationTheme {
                Column {
                    Greeting(
                        name = "Hm" + someBook.title +
                                ", is theSame = " + (someBook == theSameBook),
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(
                                PaddingValues(
                                    top = (10 +

                                            if (!connection.progress.isNaN() && connection.progress >= 0) {
                                                15 + connection.progress * 20
                                            } else {
                                                15.0f
                                            }).dp,
                                    bottom = (10 +

                                            if (!connection.progress.isNaN() && connection.progress >= 0) {
                                                connection.progress * 20
                                            } else {
                                                0.0f
                                            }).dp,
                                    start = 0.dp,
                                    end = 0.dp
                                )
                            )
                    )

                    Scaffold(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Cyan)) { _ ->
                        LazyColumn(
                            modifier = Modifier
                                .nestedScroll(connection)
                                .fillMaxSize()
                            //    .verticalScroll(state = rememberScrollState())
                        )
                        {
                            var dupa = connection.progress * 20
                            Log.d("dupa ? = ", "" + dupa)
                            stickyHeader {
                                Greeting(
                                    name = "?" + someBook.title +
                                            ", is theSame = " + (someBook == theSameBook),
                                    modifier = Modifier
                                        .background(Color.Magenta)
                                        .padding(
                                            PaddingValues(
                                                top = 50.dp,
                                                bottom = 50.dp,
                                                start = (
                                                        if (!connection.progress.isNaN() && connection.progress >= 0) {
                                                            connection.progress * 40
                                                        } else {
                                                            0.0f
                                                        }).dp
                                            )
                                        )
                                )
                            }

                            item {
                                Greeting(
                                    name = "!" + bookND1.title +
                                            ", is theSame = " + (bookND1 == bookND2),
                                    modifier = Modifier.padding(
                                        PaddingValues(
                                            start = (
                                                    if (!connection.progress.isNaN() && connection.progress >= 0) {
                                                        connection.progress * 20
                                                    } else {
                                                        0.0f
                                                    }).dp
                                        )
                                    )
                                )
                            }
                            stickyHeader {
                                Box(
                                    modifier = Modifier.background(color = Color.Black
                                    )
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 20.dp,
                                                topEnd = 20.dp
                                            )
                                        ).height(150.dp).fillMaxWidth(1.0f),


                                    content = { Text(text="dajdiasod", color = Color.White)}
                                )
                            }
                            for (i in 0..20)
                                if(i==3){
                                    item {
                                        SomeLayout(
                                            name = "" + bookND1.title +
                                                    ", is theSame = " + (bookND1 == bookND2),
                                            modifier = Modifier.padding(
                                                PaddingValues(
                                                    top = 15.dp, bottom = 15.dp,
                                                    start = 10.dp, end = 10.dp
                                                )
                                            ).background(Color.White)
                                        )
                                    }

                                }
                                else if (i == 0) {
                                    stickyHeader {
                                        SomeLayoutRounded(
                                            name = "" + bookND1.title +
                                                    ", is theSame = " + (bookND1 == bookND2),
                                            modifier = Modifier
                                                .padding(
                                                    PaddingValues(
                                                        top = 15.dp, bottom = 15.dp,
                                                        start = 10.dp, end = 10.dp
                                                    )
                                                )
                                                .background(Color.White
                                                ), color = Color.Red
                                        )
                                    }
                                } else {
                                    item {
                                        SomeLayout(
                                            name = "" + bookND1.title +
                                                    ", is theSame = " + (bookND1 == bookND2),
                                            modifier = Modifier.padding(
                                                PaddingValues(
                                                    top = 15.dp, bottom = 15.dp,
                                                    start = 10.dp, end = 10.dp
                                                )
                                            )
                                        )
                                    }


                                }
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
        Column(modifier = Modifier.background(Color.Cyan)) {

            Row(
                modifier = Modifier.fillMaxWidth(1.0f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dupa $name!",
                    modifier = modifier
                )
                Box(modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .background(Color(200, 240, 200)))

            }
            HorizontalDivider(
                modifier = Modifier.padding(start = 12.dp),
                thickness = 1.dp,
                color = Color.Red
            )
        }
    }
    @Composable
    fun SomeLayoutRounded(name: String, modifier: Modifier = Modifier, color: Color = Color.Cyan) {
        Box(Modifier.background(Color.Black)) {
            Column(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    )
                    .background(color)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(1.0f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Dupa $name!",
                        modifier = modifier
                    )
                    Box(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .background(Color(200, 240, 200))
                    )

                }
                HorizontalDivider(
                    modifier = Modifier.padding(start = 12.dp),
                    thickness = 1.dp,
                    color = Color.Red
                )
            }
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
    fun SomeLayoutRoundedPreview() {
        MyApplicationTheme {
            SomeLayoutRounded("Android")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            Greeting("Android")
        }
    }
}