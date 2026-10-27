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
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import com.example.pz5_pr_24101_ki.ui.theme.BorderColor
import com.example.pz5_pr_24101_ki.ui.theme.LabelMessage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pz5pr24101kiTheme {
                Surface (modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Conversation(SampleData)
                }
            }
        }
    }
}


@Composable
fun Conversation(messages: List<Message>){
    LazyColumn(modifier = Modifier.padding(vertical = 8.dp)) {
        items(messages) {
                message ->
            Box(modifier = Modifier.padding(bottom = 14.dp)) {
                MessageCard(message)
            }
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
                .border(1.5.dp, Color.White, CircleShape)

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
                color = LabelMessage,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(6.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp,
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.5.dp, BorderColor),
                modifier = Modifier.fillMaxWidth()

                ) {
                Text(
                    text = if (isExpanded) msg.body else msg.body.take(50) + "...",
                    modifier = Modifier.padding(vertical = 12.dp,horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.55f)
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
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            Conversation(SampleData)
        }
    }
}


data class Message(val author : String, val body: String)

val SampleData = listOf(
    Message("Wolverine", "Я лучший из лучших в том, что я делаю. Но я делаю не всё подряд, а только то, что приносит результат. Сегодня мы работаем над твоими мышцами, и я не потерплю лени!"),
    Message("Wolverine", "Мои когти из адамантия режут всё, что угодно. А твоя лень режет твой прогресс. Возьми себя в руки, иначе я лично покажу тебе, как делать планку, чтобы ты не мог встать с пола."),
    Message("Wolverine", "Все эти тренеры — просто клоуны по сравнению со мной. Я живу уже больше ста лет и знаю о тренировках больше, чем они прочитали в своих книжках. Слушай меня, и станешь сильнее."),
    Message("Wolverine", "Ты думаешь, что уже достиг предела? Ха! Я видел парней, которые выглядели как боги, но сдавались на первой минуте. Твой предел — это только твоя фантазия. Поднимай штангу!"),
    Message("Wolverine", "Не важно, сколько раз ты упадешь. Важно, сколько раз ты встанешь. Но если ты упадешь на моей тренировке, я буду смеяться над тобой, а потом заставлю отжиматься до посинения. Я — лучший!"),
    Message("Wolverine", "Я не нуждаюсь в мотивации. Я просто делаю то, что должен. Но если тебе нужен пинок под зад, я могу его организовать. Мои когти всегда наготове, и они не для красоты."),
    Message("Wolverine", "Каждый день я доказываю, что я лучший. Сегодня мой рекорд — 200 отжиманий. Твой рекорд — 10. Разница очевидна. Но это не значит, что ты должен сдаваться. Начинай!")
)


