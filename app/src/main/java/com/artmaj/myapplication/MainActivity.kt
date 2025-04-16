package com.artmaj.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.artmaj.myapplication.ui.theme.CustomTypography
import com.artmaj.myapplication.ui.theme.FilmwebYellow
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
                Box(modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth(1.0f)) {

                    val scaledConnectionProgress = connection.progress * 20
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                    ) { _ ->

                        LazyColumn(
                            modifier = Modifier
                                .nestedScroll(connection)
                                .fillMaxSize()
                                .zIndex(-10.0f)
                                .background(Color.Black)
                                .padding(
                                    top = 0.dp, bottom = 0.dp
                                )

                            //    .verticalScroll(state = rememberScrollState())
                        )
                        {
                            Log.d("dupa ? = ", "" + scaledConnectionProgress)


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
                                Header()
                            }


                            for (i in 0..40)
                                if (i == 0) {
                                    stickyHeader {
                                        Column(
                                            modifier = Modifier
                                                .padding(top = 0.dp)
                                                .offset(x = 0.dp, y = 0.dp)
                                                .height(80.dp)
                                                .fillMaxWidth(1.0f)
                                        ) {
                                            SomeLayoutRounded()
                                        }
                                    }
                                } else if (i == 1) {
                                    item {
                                        Box(Modifier
                                                .padding(0.dp)
                                                .background(Color.Yellow)
                                                .zIndex(-10.0f)
                                                .offset(0.dp, 0.dp)) {
                                            Box(Modifier
                                                    .padding(8.dp)

                                                    .background(Color.White)) {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(1.0f)
                                                        .border(
                                                            width = 1.dp,
                                                            color = Color.Red
                                                        )
                                                        .padding(13.dp),
                                                    textAlign = TextAlign.Center,
                                                    text = "#Dupa",

                                                    color = Color.Blue,
                                                )
                                            }
                                        }
                                    }


                                } else {
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

                                }
                        }


                    }

                    CustomTopMenu(1-scaledConnectionProgress*0.05f)


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
    private fun Header() {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .padding(
                    top = 0.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp
                )
        ) {

            Spacer(Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                text = "#666 TOP AKTORKI",
                style = CustomTypography.SmallInfo,
                color = Color.White,
            )

            Text(
                "AKTORKA", style = CustomTypography.SmallInfo,
                color = FilmwebYellow,
                modifier = Modifier.padding(top = 25.dp, bottom = 5.dp)
            )
            Text(
                "Anya Taylor-Joy?", style = CustomTypography.Heading1,
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            )
            Text(
                "Anya Josephine Marie Taylor-Joy",
                style = CustomTypography.SemiInfo,
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            )
            Row(modifier = Modifier.padding(top = 10.dp, bottom = 0.dp)) {
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
                        .padding(start = 15.dp, end = 15.dp, top = 15.dp),


                    content = {
                        Text(
                            text = "Anya Josephine Marie Taylor-Joy urodziła się w Miami na Florydzie jako najmłodsze z sześciorga dzieci. Jej matka ma korzenie afrykańsko-hiszpańsko-angielskie, a w żyłach ojca płynie krew szkocka\"",
                            color = Color.White,
                            style = CustomTypography.MainText,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }

            Column(
                modifier = Modifier
                    .offset(x = 0.dp, y = 10.dp)
                    .padding(bottom = 0.dp)
            ) {
                InfoRow("wiek:", "45345")

                InfoRow("urodzona:", "5t4gtg")

                InfoRow("miejsce urodzenia:", "fger g gfd")

                InfoRow("wzrost:", "45345")
            }
        }
    }

    @Composable
    private fun InfoRow(label: String, value: String) {
        Row() {
            Text(
                text = label,
                Modifier
                    .padding(horizontal = 4.dp)
                    .weight(0.75f),
                color = Color.White
            )
            Text(
                text = value,
                Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f),
                color = Color.White
            )
        }
    }

//    @Composable
//    fun CustomTopHeader(name: String, modifier: Modifier = Modifier) {
//        Greeting(
//            name = name,
//            modifier = Modifier
//                .background(Color.Transparent)
//
//                .padding(
//                    PaddingValues(
//                        top = (10 +
//
//                                if (!connection.headerOffset.isNaN() && connection.headerOffset * 20 + 15 >= 0) {
//                                    15 + connection.headerOffset * 20
//                                } else {
//                                    15.0f
//                                }).dp,
//                        bottom = (10 +
//
//                                if (!connection.headerOffset.isNaN() && connection.headerOffset >= 0) {
//                                    connection.headerOffset * 20
//                                } else {
//                                    0.0f
//                                }).dp,
//                        start = 0.dp,
//                        end = 0.dp
//                    )
//                )
//        )
//    }

    @Composable
    fun CustomTopMenu(opacity: Float) {
        Row(modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(1.0f)
            .padding(top = 20.dp)) {
            Text(modifier = Modifier.alpha(opacity),text = "Anya blabla", color = Color.White)
            Spacer(Modifier.weight(1.0f))
            Text(text = "MENU", color = Color.White)
        }
    }

    @Preview(widthDp = 300, heightDp = 100)
    @Composable
    fun CustomTopMenuPreview() {
        MyApplicationTheme {
            CustomTopMenu(1.0f)
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
        Column(modifier = Modifier
            .background(Color.Cyan)
            .offset(0.dp, 0.dp)
            .zIndex(-10.0f)) {

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
    fun SomeLayoutRounded() {
        Column(   Modifier
            .fillMaxWidth().height(200.dp)
            .background(Color.Black).offset(x=0.dp, y=50.dp)

        ) {
//            Box(Modifier
//                    .height(40.dp)
//                    .offset(x = 0.dp, y = 60.dp)
//                    .fillMaxWidth(1.0f).alpha(0.5f)
//                    .background(Color.Blue).zIndex(100.0f)
//            )
            Row(
                Modifier.offset(x = 0.dp, y = 30.dp)
                    .fillMaxWidth()
                    .height(40.dp).alpha(1f)
                    .background(Color.Transparent).zIndex(100.0f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    modifier = Modifier.width(40.dp).zIndex(1900.0f),
                    imageVector = ImageVector.vectorResource(R.drawable.leftpsd),
                    contentDescription = "blargh"
                )

                Image(
                    modifier = Modifier.width(40.dp).zIndex(1900.0f).scale(-1f,1f),
                    imageVector = ImageVector.vectorResource(R.drawable.leftpsd),
                    contentDescription = "blargh"
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .offset(x = 0.dp, y = 60.dp)
                    .zIndex(-1600.0f)

            ){
                Box(Modifier.zIndex(-1600.0f).fillMaxWidth().height(50.dp).background(Color.Transparent)
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
            SomeLayoutRounded()
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