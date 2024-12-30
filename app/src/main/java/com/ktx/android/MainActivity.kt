package com.ktx.android

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import com.ktx.android.sdui.SDUIComponent
import com.ktx.android.sdui.SDUILoader
import com.ktx.android.ui.theme.OpenandroidcomposeTheme

class MainActivity : ComponentActivity() {

    private val loader = SDUILoader()

    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenandroidcomposeTheme {
                var modifier = Modifier.fillMaxSize()
                Scaffold(modifier) { innerPadding ->
                    modifier = Modifier.padding(innerPadding)
                    Root(modifier, loader)
                    Handler().postDelayed(
                        {
                            loader.setEvent("actionButton") {
                                Toast.makeText(this, "Hello, Android!", Toast.LENGTH_SHORT).show()
                            }
                            loader.setText("titleText", "Hello, Android!")
                        }, 3000
                    )
                }
            }
        }
    }

}

@Composable
fun Root(modifier: Modifier, loader: SDUILoader) {
    val json = loadAssetString(LocalContext.current, "row_component.json").trimIndent()
    val component = Gson().fromJson(json, SDUIComponent::class.java)

    loader.Render(component)
}

private fun loadAssetString(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}