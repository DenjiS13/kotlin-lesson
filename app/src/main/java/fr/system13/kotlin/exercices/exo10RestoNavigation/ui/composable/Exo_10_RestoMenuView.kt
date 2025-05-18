package fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.system13.kotlin.exercices.exo10RestoNavigation.data.Exo_10_RestoDataService
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoMenu

@Composable
fun RestoMenuView(menu: Exo_10_RestoMenu) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((LocalConfiguration.current.screenHeightDp / 3).dp)
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
            .clickable {

            },
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(menu.mainCourse.image), contentDescription = menu.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        Surface(
            modifier = Modifier.clip(RoundedCornerShape(percent = 30)),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
        ) {
            Text(
                text = menu.name,
                fontSize = 25.sp,
                modifier = Modifier.padding(15.dp),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestoMenuViewPreview() {
    RestoMenuView(Exo_10_RestoDataService().americain)
}