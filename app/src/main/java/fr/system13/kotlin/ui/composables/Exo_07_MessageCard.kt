package fr.system13.kotlin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.R
import fr.system13.kotlin.model.Message

@Composable
fun MessageCard(message: Message) {
    Card(
        modifier = Modifier.padding(5.dp),
        shape = RoundedCornerShape(percent = 25),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        )
        {
            Image(
                painter = painterResource(message.image),
                contentDescription = stringResource(message.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = stringResource(message.name),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(bottom = 5.dp),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = message.msg,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    MessageCard(message = Message(R.string.exo_07_message_clara, R.drawable.exo_07_message_clara, "Hello World !"))
}