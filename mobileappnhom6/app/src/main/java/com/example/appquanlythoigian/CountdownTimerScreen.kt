package com.example.appquanlythoigian

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@SuppressLint("MissingPermission")
@Composable
fun CountdownTimerScreen(
    initialMinutes: Int,
    initialSeconds: Int,
    onFinish: () -> Unit
) {
    var totalSeconds by remember { mutableStateOf(initialMinutes * 60 + initialSeconds) }
    val context = LocalContext.current

    LaunchedEffect(Unit) @androidx.annotation.RequiresPermission(android.Manifest.permission.POST_NOTIFICATIONS) {
        while (totalSeconds > 0) {
            delay(1000L)
            totalSeconds--
        }
        sendNotification(context, "Hết giờ", "Đếm ngược đã hoàn thành!")
        onFinish()
    }

    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60

    Text(
        text = String.format("%02d : %02d", minutes, seconds),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}
