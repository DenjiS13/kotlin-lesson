package fr.system13.kotlin.exercices.exo08.ui.composables

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo08.data.bats
import fr.system13.kotlin.exercices.exo08.model.StrangerPost

@Composable
fun StrangerCard(post: StrangerPost) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Column {

            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
            {
                Image(
                    painter = painterResource(post.user.imageName),
                    contentDescription = post.user.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .clip(CircleShape)

                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = post.user.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 5.dp),
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton({}) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            }
            Image(
                painter = painterResource(post.imageId),
                contentDescription = post.user.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                IconButton({}) {
                    Icon(imageVector = if (post.didLike) Icons.Default.Favorite else Icons.Default.FavoriteBorder, contentDescription = null)
                }
                IconButton({}) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                }
                IconButton({}) {
                    Icon(imageVector = Icons.AutoMirrored.Default.Send, contentDescription = null)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton({}) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)
                }
            }

            Text(
                modifier = Modifier.padding(5.dp),
                text = "${post.likes} j'aime",
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = post.description,
                modifier = Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                maxLines = 2,
                color = Color(64, 64, 128, 255)
            )

            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StrangerCardPreview() {
    StrangerCard(bats)
}