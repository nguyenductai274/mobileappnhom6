package com.example.appquanlythoigian

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Screen2_End() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFCCFFFF), // Light blue
                        Color(0xFF03A9F4), // Medium blue
                        Color(0xFF0277BD)  // Dark blue
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.height(180.dp))


            Box(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .shadow(8.dp, CircleShape)
                    .background(Color(0xFF1976D2).copy(alpha = 0.8f)),
                contentAlignment = Alignment.Center
            ) {

                HieuUngTuyet(
                    modifier = Modifier.fillMaxSize(),
                    snowflakeCount = 100,
                    areaWidth = 400f,
                    areaHeight = 400f
                )
                // Timer Display
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    HieuUngTuyet(
                        modifier = Modifier,
                        snowflakeCount = 100,
                        areaWidth = 400f,
                        areaHeight = 400f
                    )
                    Spacer(modifier = Modifier.height(70.dp))
                    // Time Display
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "15",
                            fontSize = 70.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                        Text(
                            text = " : ",
                            fontSize = 70.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Text(
                            text = "20",
                            fontSize = 70.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(7.dp))

                    // End Button
                    TextButton(
                        onClick = { /* Handle start/pause */ },
                        modifier = Modifier
                            .size(120.dp)
                    ) {
                        Text(
                            text = "END",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            // Bottom Navigation
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.9f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Focus Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Focus",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Focus",
                            fontSize = 12.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Report Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.List,
                            contentDescription = "Report",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Report",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Me Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Me",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Me",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun HieuUngTuyet(
    modifier: Modifier = Modifier,
    snowflakeCount: Int = 100,
    areaWidth: Float,
    areaHeight: Float
) {
    val snowflakes = remember {
        List(snowflakeCount) {
            Snowflake(
                x = Random.nextFloat() * areaWidth,
                y = Random.nextFloat() * areaHeight,
                radius = Random.nextFloat() * 10f + 2f,
                speedY = Random.nextFloat() * 1.5f + 0.5f
            )
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            withFrameNanos {
                snowflakes.forEach {
                    it.y += it.speedY
                    if (it.y > areaHeight) {
                        it.y = 0f
                        it.x = Random.nextFloat() * areaWidth
                    }
                }
            }
        }
    }

    Canvas(modifier = modifier) {
        snowflakes.forEach {
            drawCircle(
                color = Color.White,
                radius = it.radius,
                center = Offset(it.x, it.y)
            )
        }
    }
}
data class Snowflake(
    var x: Float,
    var y: Float,
    var radius: Float,
    var speedY: Float
)

