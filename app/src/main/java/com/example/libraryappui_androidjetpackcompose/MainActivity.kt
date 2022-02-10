package com.example.libraryappui_androidjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryappui_androidjetpackcompose.ui.theme.LibraryAppUIAndroidJetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryAppUIAndroidJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainApp() {
    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetPeekHeight = 260.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 12.dp),
        topBar = {
            Row(
                Modifier
                    .padding(start = 28.dp, end = 28.dp, top = 45.dp, bottom = 31.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "20",
                    fontWeight = FontWeight.Bold,
                    fontSize = 38.sp
                )
                Column(Modifier.weight(1f)) {
                    Text(
                        text = "Thu",

                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Dec 2021",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.QrCode, contentDescription = "QR Code")
                }
                Image(
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(12.dp))
                )
            }
        },
        sheetContent = {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "My books",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 28.dp)
            )
            LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
                items(myBookItems) { book ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .clickable { }
                            .padding(horizontal = 28.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = book.book.image),
                            contentScale = ContentScale.FillHeight,
                            contentDescription = "Cover",
                            modifier = Modifier
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Column(Modifier.weight(1f)) {
                            Text(
                                text = book.book.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(text = book.book.author, fontSize = 13.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "Return until ${book.returnDate}",
                                color = MaterialTheme.colors.primary,
                                fontSize = 13.sp
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu")
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "New arrivals",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f)
                )
                TextButton(onClick = {}, contentPadding = PaddingValues(horizontal = 0.dp)) {
                    Text(text = "View all")
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = "View All")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 28.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items) { book ->
                    Column(
                        Modifier
                            .width(130.dp)
                            .clickable { }) {
                        Image(
                            painter = painterResource(id = book.image),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = book.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = book.author, color = Color.Gray, fontSize = 13.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainApp()
}