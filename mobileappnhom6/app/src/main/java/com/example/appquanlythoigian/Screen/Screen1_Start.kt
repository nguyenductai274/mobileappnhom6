    package com.example.appquanlythoigian.Screen

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
    import androidx.compose.ui.graphics.Brush
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.ui.draw.shadow
    import androidx.compose.ui.window.Dialog
    import androidx.navigation.NavController

    @Composable
    fun ChinhTime(
        title: String,
        currentValue: Int,
        maxValue: Int,
        onValueSelected: (Int) -> Unit,
        onDismiss: () -> Unit
    ) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Number picker
                    LazyColumn(
                        modifier = Modifier
                            .height(200.dp)
                            .width(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(maxValue + 1) { value ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .clickable { onValueSelected(value) }
                                    .background(
                                        if (value == currentValue) Color.Blue.copy(alpha = 0.2f)
                                        else Color.Transparent,
                                        RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = String.format("%02d", value),
                                    fontSize = 18.sp,
                                    fontWeight = if (value == currentValue) FontWeight.Bold else FontWeight.Normal,
                                    color = if (value == currentValue) Color.Blue else Color.Black
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        TextButton(onClick = onDismiss) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Screen1_Start(navController: NavController) {
        var minutes by remember { mutableStateOf(0) }
        var seconds by remember { mutableStateOf(0) }
        var showMinutePicker by remember { mutableStateOf(false) }
        var showSecondPicker by remember { mutableStateOf(false) }

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

                Box(modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .shadow(8.dp,CircleShape)
                    .background(Color(0xFF1976D2).copy(alpha = 0.8f)),
                    contentAlignment = Alignment.Center
                    ){
                    // Timer Display
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(70.dp))
                        // Time Display
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = String.format("%02d", minutes),
                                fontSize = 70.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                                    .clickable { showMinutePicker = true }
                                    .padding(8.dp)
                            )

                            Text(
                                text = " : ",
                                fontSize = 70.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            Text(
                                text = String.format("%02d", seconds),
                                fontSize = 70.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                                    .clickable { showSecondPicker = true }
                                    .padding(8.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(7.dp))

                        // Start Button
                        TextButton(
                            onClick = { navController.navigate("End/$minutes/$seconds") },
                            modifier = Modifier
                                .size(120.dp)
                        ) {
                            Text(
                                text = "START",
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
                                .clickable {
                                    navController.navigate("Viec")
                                }
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
                                .clickable {
                                    navController.navigate("Start")
                                }
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

            // Show dialogs
            if (showMinutePicker) {
                ChinhTime(
                    title = "Số phút",
                    currentValue = minutes,
                    maxValue = 59,
                    onValueSelected = { newMinutes ->
                        minutes = newMinutes
                    },
                    onDismiss = { showMinutePicker = false }
                )
            }

            if (showSecondPicker) {
                ChinhTime(
                    title = "Số giây",
                    currentValue = seconds,
                    maxValue = 59,
                    onValueSelected = { newSeconds ->
                        seconds = newSeconds
                    },
                    onDismiss = { showSecondPicker = false }
                )
            }
        }
    }