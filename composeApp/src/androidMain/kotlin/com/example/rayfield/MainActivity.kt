package com.example.rayfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.rayfield.domain.helpers.ClipboardHelper
import com.example.rayfield.ui.decoration.Circles
import com.example.rayfield.ui.decoration.circlesAndroid
import com.example.rayfield.ui.state.GlobalBlurHolder
import com.example.rayfield.ui.theme.RayFieldTheme
import io.github.neilyich.glassmorphism.blurredContent
import io.github.neilyich.glassmorphism.rememberBlurHolder
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        Security.removeProvider("BC")
        Security.insertProviderAt(BouncyCastleProvider(), 1)

        val data = intent?.data
        val configId = data?.getQueryParameter("configId")
        val serverId = data?.getQueryParameter("serverId")

        setContent {
            val blurHolder = rememberBlurHolder()
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                ClipboardHelper.init(context)
            }

            RayFieldTheme {
                CompositionLocalProvider(GlobalBlurHolder provides blurHolder) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .blurredContent(blurHolder)
                        ) { Circles(circlesAndroid()) }
                        App(
                            modifier = Modifier.fillMaxSize().padding(innerPadding),
                            initialConfigId = configId,
                            initialServerId = serverId
                        )
                    }
                }
            }
        }
    }
}