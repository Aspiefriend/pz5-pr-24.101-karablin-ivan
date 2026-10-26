package com.example.pz5_pr_24101_ki

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pz5_pr_24101_ki.ui.theme.Pz5pr24101kiTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pz5pr24101kiTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    Conversation(SampleData)
                }
            }
        }
    }
}


@Composable
fun Conversation(messages: List<Message>){
    LazyColumn {
        items(messages) {
                message ->
            MessageCard(message)
        }
    }

}
@Composable
fun MessageCard(msg: Message) {

    var isExpanded by remember { mutableStateOf(false) }


    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        label = "surfaceColor"
    )
    Row(modifier = Modifier
        .padding(all = 8.dp)
        .clickable { isExpanded = !isExpanded }
    ) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)

        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp,
                color = surfaceColor

                ) {
                Text(
                    text = if (isExpanded) msg.body else msg.body.take(20) + "...",
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard(){
    Pz5pr24101kiTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Conversation(SampleData)
        }
    }
}


data class Message(val author : String, val body: String)

val SampleData = listOf(
    Message("Kotlin", "Привет! Это первое сообщение в списке."),
    Message("Android", "Добро пожаловать в Jetpack Compose."),
    Message("Тренер", "Не забудь про тренировку сегодня!"),
    Message("FitPro", "Твоя статистика улучшилась на 10%.")
)


