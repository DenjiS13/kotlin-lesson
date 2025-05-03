package fr.system13.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class MainActivity : ComponentActivity() {
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
                var nameString by remember { mutableStateOf("") }
                var firstnameString by remember { mutableStateOf("") }

                NameTextField(nameString = nameString, onValueChange = { nameString = it }, focusManager = focusManager)
                FirstNameTextField(firstnameString = firstnameString, onValueChange = { firstnameString = it }, focusManager = focusManager)
            }
        }
    }

    @Composable
    fun FirstNameTextField(firstnameString: String, onValueChange: (String) -> Unit, focusManager: FocusManager) {

        val error = firstnameString == ""

        OutlinedTextField(
            value = firstnameString,
            onValueChange = onValueChange,
            label = { Text(text = "Prénom") },
            modifier = Modifier.padding(12.dp),
            singleLine = true,
            enabled = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
            readOnly = false,
            isError = error,
            keyboardOptions = KeyboardOptions(
                showKeyboardOnFocus = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done  // action effectuée par la touche enter ou suivant du clavier virtuel
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            placeholder = { Text(text = "Entrez votre prénom") }, // = Watermark
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
            },
            colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
            )
        )
        if (error) Text(text = "Error", color = MaterialTheme.colorScheme.error)

    }

    @Composable
    fun NameTextField(nameString: String, onValueChange: (String) -> Unit, focusManager: FocusManager) {

        TextField(
            value = nameString,
            onValueChange = onValueChange,
            label = { Text(text = "Nom") },
            modifier = Modifier.padding(12.dp),
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
            placeholder = { Text(text = "Entrez votre nom") }, // = Watermark
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
            },
            colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}