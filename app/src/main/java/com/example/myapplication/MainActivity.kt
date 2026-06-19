package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat.Type
import androidx.compose.runtime.Composable
import com.smartbike.retrofit.ui.navigation.SmartBikeNavGraph
import com.smartbike.retrofit.data.session.SessionManager
import com.smartbike.retrofit.ui.theme.RetrofitSmartBikeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Edge-to-edge: allow drawing behind system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Initialize session manager early so ApiClient interceptor can read token
        SessionManager.initialize(applicationContext)

        setContent {
            RetrofitSmartBikeTheme {
                MyApplicationApp()
            }
        }

        // Apply window insets to the root view so that bottom navigation / bottom bar
        // is shifted up by the system bar inset (no hardcoded dp values).
        val root: View = findViewById(android.R.id.content)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val sysInsets = insets.getInsets(Type.systemBars())
            // Apply bottom inset as padding to the root content view
            v.setPadding(v.paddingLeft, v.paddingTop, v.paddingRight, sysInsets.bottom)
            insets
        }
    }
}

@Composable
fun MyApplicationApp() {
    SmartBikeNavGraph()
}