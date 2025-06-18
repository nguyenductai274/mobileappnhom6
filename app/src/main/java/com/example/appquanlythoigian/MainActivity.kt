package com.example.appquanlythoigian

<<<<<<< HEAD
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
=======
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.compose.*
import androidx.compose.ui.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
>>>>>>> 4972998 (Done Đồng hồ đếm ngược - thông báo)
import com.example.appquanlythoigian.ui.theme.AppQuanLyThoiGianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppQuanLyThoiGianTheme {
<<<<<<< HEAD
                //Screen1_Start()
                //Screen2_End()
                Screen3_ThemViec()
=======
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 100)
                    }
                }

                JetpackComposeApp()
>>>>>>> 4972998 (Done Đồng hồ đếm ngược - thông báo)
            }
        }
    }
}

