package com.artmaj.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artmaj.myapplication.ui.theme.CustomTypography
import com.artmaj.myapplication.ui.theme.MyApplicationTheme
import com.artmaj.myapplication.ui.theme.Typography
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
                Box(modifier = Modifier.background(Color.Blue).fillMaxWidth(1.0f)) {

                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red)
                    ) { _ ->
                        LazyColumn(
                            modifier = Modifier
                                .nestedScroll(connection)
                                .fillMaxSize()
                                .background(Color.Magenta).padding(top = 80.dp)
                            //    .verticalScroll(state = rememberScrollState())
                        )
                        {
                            var dupa = connection.progress * 20
                            Log.d("dupa ? = ", "" + dupa)


//                            item {
//                                Greeting(
//                                    name = "!" + bookND1.title +
//                                            ", is theSadme = " + (bookND1 == bookND2),
//                                    modifier = Modifier.padding(
//                                        PaddingValues(
//                                            top = 20.dp,
//                                            start = (
//                                                    if (!connection.headerOffset.isNaN() && connection.headerOffset >= 0) {
//                                                        connection.headerOffset * 20
//                                                    } else {
//                                                        0.0f
//                                                    }).dp
//                                        )
//                                    )
//                                )
//                            }
                            item {
                                Column(
                                    modifier = Modifier
                                        .background(Color.Black)
                                        .padding(top = 50.dp, start = 10.dp, end = 10.dp)
                                ) {

                                    Text(
                                        "AKTORKA", style = CustomTypography.SmallInfo,
                                        color = com.artmaj.myapplication.ui.theme.FilmwebYellow
                                    )
                                    Text(
                                        "Anya Taylor-Joy?", style = CustomTypography.Heading1,
                                        color = Color.White
                                    )
                                    Text(
                                        "Anya josephine Marie Taylor-Joy",
                                        style = CustomTypography.SemiInfo,
                                        color = Color.White
                                    )
                                    Row(modifier = Modifier.padding(bottom = 20.dp)) {
                                        Box(
                                            modifier = Modifier
                                                .background(
                                                    color = Color.Red
                                                )
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 10.dp,
                                                        topEnd = 10.dp
                                                    )
                                                )
                                                .height(160.dp)
                                                .width(120.dp)
                                        )

                                        { Text(text = "", color = Color.White) }

                                        Box(
                                            modifier = Modifier
                                                .background(
                                                    color = Color.Black
                                                )
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 20.dp,
                                                        topEnd = 20.dp
                                                    )
                                                )
                                                .height(150.dp)
                                                .fillMaxWidth(1.0f)
                                                .padding(15.dp),


                                            content = {
                                                Text(
                                                    text = "Anya Josephine Marie Taylor-Joy urodziła się w Miami na Florydzie jako najmłodsze z sześciorga dzieci. Jej matka ma korzenie afrykańsko-hiszpańsko-angielskie, a w żyłach ojca płynie krew szkocka\"",
                                                    color = Color.White,
                                                    style = CustomTypography.MainText
                                                )
                                            }
                                        )
                                    }
                                }
                            }


                            for (i in 0..20)
                                if (i == 3) {
                                    item {
                                        SomeLayout(
                                            name = "" + bookND1.title +
                                                    ", is theSame = " + (bookND1 == bookND2),
                                            modifier = Modifier
                                                .padding(
                                                    PaddingValues(
                                                        top = 15.dp, bottom = 15.dp,
                                                        start = 10.dp, end = 10.dp
                                                    )
                                                )
                                                .background(Color.White)
                                        )
                                    }

                                } else if (i == 0) {
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
                                                .background(
                                                    Color.White
                                                ), color = Color.White
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

                    CustomTopMenu(
                    )


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
    fun CustomTopHeader(name: String, modifier: Modifier = Modifier) {
        Greeting(
            name = name,
            modifier = Modifier
                .background(Color.Transparent)

                .padding(
                    PaddingValues(
                        top = (10 +

                                if (!connection.headerOffset.isNaN() && connection.headerOffset * 20 + 15 >= 0) {
                                    15 + connection.headerOffset * 20
                                } else {
                                    15.0f
                                }).dp,
                        bottom = (10 +

                                if (!connection.headerOffset.isNaN() && connection.headerOffset >= 0) {
                                    connection.headerOffset * 20
                                } else {
                                    0.0f
                                }).dp,
                        start = 0.dp,
                        end = 0.dp
                    )
                )
        )
    }

    @Composable
    fun CustomTopMenu() {
        Row(modifier = Modifier
            .height(IntrinsicSize.Min).fillMaxWidth(1.0f).padding(top = 20.dp)) {
            Text("Anya blabla")
            Spacer(Modifier.weight(1.0f))
            Text(text = "MENU", color = Color.White)
        }
    }

    @Preview(widthDp = 300, heightDp = 100)
    @Composable
    fun CustomTopMenuPreview() {
        MyApplicationTheme {
            CustomTopMenu()
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.White
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

                    Box(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
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