package com.example.appquanlythoigian.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BangThemViec(onDismiss: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(onClick = onDismiss) // click ra ngoài để tắt
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(enabled = false) {}, // Ngăn tắt dialog khi nhấn vào bên trong
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row {
                    Text(text = "--/--/----")
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Thời gian bắt đầu")
                }

                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Thời lượng làm việc", modifier = Modifier.padding(vertical = 8.dp))
                Divider()

                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Mô tả công việc / tên công việc / to do list") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Delete")
                    }
                    Button(onClick = onDismiss) {
                        Text("Set")
                    }
                }
            }
        }
    }
}