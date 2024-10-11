package com.example.grid

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.grid.ui.theme.GridTheme
import singletons.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridTheme {
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 192.dp),
                    Modifier
                        .background(color = Color(0xFF1E2021))
                        .safeDrawingPadding()
                    ,
                    contentPadding = PaddingValues(4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                    items(DataSource.topics.size) { index ->
                        Topic(
                            img = DataSource.topics[index].img, // Access image resource ID from the topic object
                            numberOfCourses = DataSource.topics[index].numberOfCourses, // Access number of courses from the topic object
                            title = DataSource.topics[index].title // Access title resource ID from the topic object
                        )
//                        Topic(img = R.drawable.law , numberOfCourses = 20 , title = R.string.business)
                    }
                }


            }
        }
    }
}




@Composable
fun Topic(@DrawableRes img : Int , @StringRes title : Int , numberOfCourses : Int,modifier: Modifier = Modifier){
    Card(modifier.height(68.dp)) {
        Row (modifier){
            Image(painterResource(id = img), stringResource(id = title),modifier = Modifier
                .width(68.dp)
                .height(68.dp))
            Column (modifier.padding(end = 16.dp, top = 16.dp)){

                Text(stringResource(id = title), modifier.padding( start = 16.dp,bottom = 8.dp ))
                Row (modifier){
                    Spacer(modifier.width(16.dp))
                    Image(painterResource(id = R.drawable.screenshot_2024_10_11_122621), contentDescription = null,modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        )
                    Spacer(modifier.width(8.dp))
                    Text(numberOfCourses.toString())
                }
            }

        }
    }
}