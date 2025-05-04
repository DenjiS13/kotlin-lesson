package fr.system13.kotlin.exercices

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.R
import fr.system13.kotlin.ui.theme.KotlinLessonTheme
import kotlin.math.roundToInt

class Exercice_06_Calories : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                CaloriesScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            CaloriesScaffold()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun CaloriesScaffold() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = { CaloriesAppBar() },
            )
            { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    CaloriesBody()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CaloriesAppBar() {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.exo_06_calories_appbar),
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        )
    }

    @Composable
    fun CaloriesBody() {
        val focusManager = LocalFocusManager.current
        Surface(modifier = Modifier.fillMaxSize(), onClick = { focusManager.clearFocus() })
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                var nameString by remember { mutableStateOf("") }
                var ageString by remember { mutableStateOf("") }
                var genreIsMale by remember { mutableStateOf(true) }
                var weight by remember { mutableIntStateOf(99) }
                var size by remember { mutableFloatStateOf(176F) }
                val activities = listOf("Sédentaire", "Faible", "Actif", "Sportif", "Athlète")
                var activity by remember { mutableIntStateOf(0) }
                var result: Int? by remember { mutableStateOf(null) }

                val modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                NameTextField(nameString, { nameString = it }, focusManager, modifier)
                AgeTextField(ageString, { ageString = it }, focusManager, modifier)
                GenderSwitch(genreIsMale, { genreIsMale = it }, modifier)
                WeightStepper(weight, { weight = it }, modifier)
                SizeSlider(size, {
                    val newSize = it.roundToInt().toFloat()
                    if (size != newSize) size = newSize
                }, {}, modifier)
                ActivityRadioButtons(activity, activities, { activity = it }, modifier)
                Button(onClick = { result = getResult(nameString, ageString, genreIsMale, weight, size, activity) }) {
                    Text(text = stringResource(R.string.exo_06_calories_calc))
                }
                Spacer(Modifier.padding(20.dp))
                Text(text = if (result == null) "..." else stringResource(R.string.exo_06_calories_result, nameString, result!!))
            }
        }
    }

    private fun getResult(nameString: String, ageString: String, genreIsMale: Boolean, weight: Int, size: Float, activity: Int): Int? {

        if (nameString == "" || ageString.toIntOrNull() == null || weight < 40 || weight > 120)
            return null

        var result = (10 * weight) + (6.25 * size) - (5 * ageString.toInt())

        result = if (genreIsMale) result + 5 else result - 161

        result*= getActivityModifier(activity)

        return result.roundToInt()
    }

    private fun getActivityModifier(activity: Int): Double {
        return when (activity) {
            0 -> 1.2
            1 -> 1.375
            2 -> 1.55
            3 -> 1.72
            else -> 1.9
        }
    }

    @Composable
    fun NameTextField(
        nameString: String,
        onValueChange: (String) -> Unit,
        focusManager: FocusManager,
        modifier: Modifier
    ) {

        TextField(
            value = nameString,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(R.string.exo_06_calories_name_label)) },
            modifier = modifier,
            singleLine = true,
            enabled = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
            readOnly = false,
            isError = nameString == "",
            keyboardOptions = KeyboardOptions(
                showKeyboardOnFocus = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next  // action effectuée par la touche enter ou suivant du clavier virtuel
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            placeholder = { Text(text = stringResource(R.string.exo_06_calories_name_placeholder)) }, // = Watermark
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )
    }

    @Composable
    fun AgeTextField(
        ageString: String,
        onValueChange: (String) -> Unit,
        focusManager: FocusManager,
        modifier: Modifier
    ) {

        OutlinedTextField(
            value = ageString,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(R.string.exo_06_calories_age_label)) },
            modifier = modifier,
            singleLine = true,
            enabled = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
            readOnly = false,
            isError = ageString.toIntOrNull() == null,
            keyboardOptions = KeyboardOptions(
                showKeyboardOnFocus = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next  // action effectuée par la touche enter ou suivant du clavier virtuel
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            placeholder = { Text(text = stringResource(R.string.exo_06_calories_age_placeholder)) }, // = Watermark
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(onClick = { print("click") }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
        )
    }

    @Composable
    fun GenderSwitch(
        value: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        modifier: Modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = if (value) stringResource(R.string.exo_06_calories_gender_male) else stringResource(R.string.exo_06_calories_gender_female))
            Switch(
                checked = value,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.LightGray,     // partie vide (avec de l'alpha)
                    checkedThumbColor = Color(0xFF69B4FF),      // Gros point
                    checkedBorderColor = Color.DarkGray,   // Bordure
                    uncheckedTrackColor = Color.LightGray,     // partie vide (avec de l'alpha)
                    uncheckedThumbColor = Color(0xFFFF69B4),      // Gros point
                    uncheckedBorderColor = Color.DarkGray,   // Bordure
                )
            )
        }
    }

    @Composable
    fun WeightStepper(
        weight: Int,
        onTap: (Int) -> Unit,
        modifier: Modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(R.string.exo_06_calories_weight, weight))
            Surface(
                modifier = Modifier.height(45.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(percent = 15)
            ) {
                Row {
                    IconButton(onClick = { onTap(weight + 1) }) { Text(text = "+") }
                    IconButton(onClick = { onTap(weight - 1) }) { Text(text = "-") }
                }
            }
        }
    }

    @Composable
    fun SizeSlider(
        value: Float,
        onValueChange: (Float) -> Unit,
        onChangeFinished: () -> Unit,
        modifier: Modifier
    ) {
        Column(
            modifier = modifier,
        ) {
            Text(text = stringResource(R.string.exo_06_calories_size, value.toInt()))
            Slider(
                value = value,
                valueRange = 130F..200F,
                onValueChange = onValueChange,
                onValueChangeFinished = onChangeFinished,
            )
        }
    }

    @Composable
    fun ActivityRadioButtons(
        activityIndex: Int,
        activityList: List<String>,
        onClick: (Int) -> Unit,
        modifier: Modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (index in activityList.indices) {
                Column {
                    RadioButton(
                        selected = index == activityIndex,
                        onClick = { onClick(index) }
                    )
                    Text(activityList[index])
                }
            }
        }
    }
}