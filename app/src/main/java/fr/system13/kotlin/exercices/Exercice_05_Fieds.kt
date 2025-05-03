package fr.system13.kotlin.exercices

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.R
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exercice_05_Fieds : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                FieldsScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            FieldsScaffold()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun FieldsScaffold() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold()
            { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    FieldsBody()
                }
            }
        }
    }

    @Composable
    fun FieldsBody() {
        val focusManager = LocalFocusManager.current
        Surface(modifier = Modifier.fillMaxSize(), onClick = { focusManager.clearFocus() })
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val fruits = listOf("Pêche", "Banane", "Pomme", "Poire", "Abricot")
                val modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()

                var nameString by remember { mutableStateOf("") }
                var firstnameString by remember { mutableStateOf("") }
                var passwordString by remember { mutableStateOf("") }
                var isKotlinCool by remember { mutableStateOf(true) }
                var sliderValue by remember { mutableFloatStateOf(53F) }
                var fruitIndex by remember { mutableIntStateOf(0) }
                var stepperNumber by remember { mutableIntStateOf(0) }

                NameTextField(nameString, { nameString = it }, focusManager, modifier)
                SecureTextField(passwordString, { passwordString = it }, focusManager, modifier)
                FirstNameTextField(firstnameString, { firstnameString = it }, focusManager, modifier)
                KotlinCoolSwitch(isKotlinCool, { isKotlinCool = it }, modifier)
                AgeSlider(sliderValue, { sliderValue = it }, {}, modifier)
                FruitsRadioButtons(fruitIndex, fruits, { fruitIndex = it }, modifier)
                Stepper(stepperNumber, { stepperNumber = it }, modifier)
            }
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
            label = { Text(text = stringResource(R.string.exo_05_fields_name_label)) },
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
            placeholder = { Text(text = stringResource(R.string.exo_05_fields_name_placeholder)) }, // = Watermark
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
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
    fun SecureTextField(
        password: String,
        onValueChange: (String) -> Unit,
        focusManager: FocusManager,
        modifier: Modifier
    ) {
        var isSecure by remember { mutableStateOf(true) }

        OutlinedTextField(
            value = password,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(R.string.exo_05_fields_password_label)) },
            modifier = modifier,
            visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { isSecure = !isSecure }) {
                    Icon(
                        imageVector = if (isSecure) Icons.Default.Lock else Icons.Default.Warning,
                        contentDescription = null
                    )
                }
            },
            singleLine = true,
            enabled = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
            readOnly = false,
            isError = password == "",
            keyboardOptions = KeyboardOptions(
                showKeyboardOnFocus = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next  // action effectuée par la touche enter ou suivant du clavier virtuel
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            placeholder = { Text(text = stringResource(R.string.exo_05_fields_password_placeholder)) }, // = Watermark
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null
                )
            }
        )
    }

    @Composable
    fun FirstNameTextField(
        firstnameString: String,
        onValueChange: (String) -> Unit,
        focusManager: FocusManager,
        modifier: Modifier
    ) {

        val error = firstnameString == ""

        OutlinedTextField(
            value = firstnameString,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(R.string.exo_05_fields_firstname_label)) },
            modifier = modifier,
            singleLine = true,
            enabled = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
            readOnly = false,
            isError = error,
            keyboardOptions = KeyboardOptions(
                showKeyboardOnFocus = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done // action effectuée par la touche enter ou suivant du clavier virtuel
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            placeholder = { Text(text = stringResource(R.string.exo_05_fields_firstname_placeholder)) }, // = Watermark
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
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
        if (error) Text(text = "Error", color = MaterialTheme.colorScheme.error)
    }

    @Composable
    fun KotlinCoolSwitch(
        isKotlinCool: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        modifier: Modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = isKotlinCool,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.LightGray,     // partie vide (avec de l'alpha)
                    checkedThumbColor = Color.Green,      // Gros point
                    checkedBorderColor = Color.DarkGray,   // Bordure
                    uncheckedTrackColor = Color.LightGray,     // partie vide (avec de l'alpha)
                    uncheckedThumbColor = Color.Red,      // Gros point
                    uncheckedBorderColor = Color.DarkGray,   // Bordure
                )
            )
            Text(
                text = if (isKotlinCool)
                    stringResource(R.string.exo_05_fields_is_kotlin_cool_yes)
                else
                    stringResource(R.string.exo_05_fields_is_kotlin_cool_no)
            )
        }
    }

    @Composable
    fun AgeSlider(
        value: Float,
        onValueChange: (Float) -> Unit,
        onChangeFinished: () -> Unit,
        modifier: Modifier
    ) {
        Column(
            modifier = modifier,
        ) {
            Slider(
                value = value,
                valueRange = 30F..100F,
                steps = 1,
                onValueChange = onValueChange,
                onValueChangeFinished = onChangeFinished,
            )
            Text(text = stringResource(R.string.exo_05_fields_age, value.toInt()))
        }
    }

    @Composable
    fun FruitsRadioButtons(
        index: Int,
        list: List<String>,
        onClick: (Int) -> Unit,
        modifier: Modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (fruitIndex in list.indices) {
                Column {
                    RadioButton(
                        selected = index == fruitIndex,
                        onClick = { onClick(fruitIndex) }
                    )
                    Text(list[fruitIndex])
                }
            }
        }
    }

    @Composable
    fun Stepper(
        number: Int,
        onTap: (Int) -> Unit,
        modifier: Modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(R.string.exo_05_fields_stepper, number))
            Surface(
                modifier = Modifier.height(45.dp),
                border = BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(percent = 15)
            ) {
                Row {
                    IconButton(onClick = { onTap(number - 1) }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { onTap(number + 1) }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}