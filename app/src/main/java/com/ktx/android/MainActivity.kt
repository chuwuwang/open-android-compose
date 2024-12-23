package com.ktx.android

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.bot.nova.NovaLoader
import com.bot.nova.component.text.TextComponent
import com.bot.nova.utils.info
import com.google.gson.Gson
import com.ktx.android.ui.theme.OpenandroidcomposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenandroidcomposeTheme {
                var modifier = Modifier.fillMaxSize()
                Scaffold(modifier) { innerPadding ->
                    modifier = Modifier.padding(innerPadding)
                    Root(modifier)
                }
            }
        }
    }

}

@Preview
@Composable
fun Root(modifier: Modifier) {
    val json = loadAssetString(LocalContext.current, "text_component.json").trimIndent()
    val component = Gson().fromJson(json, TextComponent::class.java)
    info("component: $component")
    NovaLoader().Render(component)
}

private fun loadAssetString(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}