package com.ktx.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.bot.nova.text.TextComponent
import com.bot.nova.component.text.TextRender
import com.ktx.android.ui.theme.OpenandroidcomposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenandroidcomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Render(Modifier.padding(innerPadding))
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Render(modifier: Modifier) {
    val serverJson = """
{
    "type": "text",
    "id": "welcomeText",
    "text": "Hello world",
    "style": {
        "width": 200,
        "height": 100,
        "font": "normal-1",
        "color": "#000000",
        "backgroundColor": "#FFFFFF",
        "textAlign": "center",
        "borderRadius": 8,
        "minWidth": null,
        "maxWidth": null,
        "minHeight": null,
        "maxHeight": null,
        "lineLimit": 3,
        "padding": {
            "top": 10,
            "bottom": 10,
            "left": 15,
            "right": 15
        }
    },
    "actions": [
        {
            "event": "onClick",
            "target": "function://route?url=xxxxx"
        },
        {
            "event": "onLongPress",
            "target": "function://customAction?param=yyyyy"
        }
    ]
}
""".trimIndent()
    val component = Gson().fromJson(serverJson, com.bot.nova.text.TextComponent::class.java)
    Log.d("MainActivity", "component: $component")
    com.bot.nova.component.text.TextRender(component = component, text = component.text)
}