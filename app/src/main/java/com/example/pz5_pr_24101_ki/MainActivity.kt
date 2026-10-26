package com.example.pz5_pr_24101_ki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pz5_pr_24101_ki.ui.theme.Pz5pr24101kiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MessageCard(msg = Message("Kotlin", "JetPack Compose"))

        }
    }
}
@Composable
fun MessageCard(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)

}
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(msg = Message("Kotlin", "JetPack Compose"))
}

data class Message(val author : String, val body: String)


