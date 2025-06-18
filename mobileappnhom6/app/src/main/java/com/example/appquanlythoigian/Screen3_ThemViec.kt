package com.example.appquanlythoigian

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@Composable
fun Screen3_ThemViec() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFB3E5FC), Color(0xFF03A9F4)))
            )
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        // Top header
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = "Month", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        // Week days header with arrows
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /* TODO: Previous week */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
                }
            }
            var selectedDay by remember { mutableStateOf("Mon") }
            val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                days.forEach { day ->
                    Text(
                        text = day,
                        modifier = Modifier
                            .clickable { selectedDay = day }
                            .padding(horizontal = 6.dp, vertical = 4.dp)
                            .background(
                                if (day == selectedDay) Color.LightGray else Color.Transparent,
                                RoundedCornerShape(4.dp)
                            )
                            .padding(4.dp),
                        fontSize = 14.sp,
                        fontWeight = if (day == selectedDay) FontWeight.Bold else FontWeight.Normal,
                        color = Color.Black
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /* TODO: Next week */ }) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Next")
                }
            }
        }

        // White table for schedule (7 columns)
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .background(Color.White, RoundedCornerShape(16.dp))
        ) {
            repeat(7) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, Color.LightGray)
                )
            }
        }

        // Plus Button
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { /* TODO: Add new event */ },
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, shape = CircleShape)
                    .border(2.dp, Color.Black, shape = CircleShape)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

        // Bottom Navigation
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            ,
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
