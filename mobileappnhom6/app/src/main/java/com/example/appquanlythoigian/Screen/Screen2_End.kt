package com.example.appquanlythoigian.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appquanlythoigian.CountdownTimerScreen
import kotlin.random.Random

@Composable
fun Screen2_End(navController: NavController, minutes: Int, seconds: Int) {
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
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Tuyet(
                    modifier = Modifier
                        .size(300.dp)
                        .background(Color(0xFF03A9F4), shape = RoundedCornerShape(16.dp))
                )
                HalfCircle()

                // ✅ Đồng hồ đếm ngược thay thế đoạn text cứng
                CountdownTimerScreen(
                    initialMinutes = minutes,
                    initialSeconds = seconds,
                    onFinish = {
                        navController.navigate("Start")
                    }
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            // END Button
            TextButton(
                onClick = { navController.navigate("Start") },
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
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
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
                            .clickable { navController.navigate("Start") }
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
                            color = Color.Black
                        )
                    }

                    // Report Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                            .clickable { navController.navigate("Viec") }
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
                            color = Color.Gray
                        )
                    }

                    // Me Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                            .clickable { navController.navigate("Start") }
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
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Các phần tuyết và nửa vòng tròn giữ nguyên
@Composable
fun Tuyet(modifier: Modifier = Modifier, dotCount: Int = 100) {
    val dots = remember {
        List(dotCount) {
            Snow(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                radius = Random.nextFloat() * 20f + 5f,
                color = Color(
                    red = Random.nextFloat(),
                    green = Random.nextFloat(),
                    blue = Random.nextFloat(),
                    alpha = 1f
                )
            )
        }
    }

    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        dots.forEach { dot ->
            drawCircle(
                color = Color.White,
                radius = dot.radius,
                center = Offset(dot.x * canvasWidth, dot.y * canvasHeight)
            )
        }
    }
}

@Composable
fun HalfCircle() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawArc(
            color = Color(0xFF0065F8),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(0f, 0f),
            size = Size(size.width, size.height)
        )
    }
}

data class Snow(
    var x: Float,
    var y: Float,
    var radius: Float,
    val color: Color
)
