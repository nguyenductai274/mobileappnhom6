package com.example.appquanlythoigian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appquanlythoigian.ui.theme.AppQuanLyThoiGianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppQuanLyThoiGianTheme {
                //Screen1_Start()
                //Screen2_End()
                Screen3_ThemViec()
            }
        }
    }
}

