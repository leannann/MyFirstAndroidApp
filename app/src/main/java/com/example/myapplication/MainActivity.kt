package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val EXTRA_TEXT = "extra_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current
    var inputText by rememberSaveable { mutableStateOf("") }
    var inputError by rememberSaveable { mutableStateOf<String?>(null) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                    inputError = null
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Введите текст или телефон") },
                singleLine = true,
                isError = inputError != null,
                supportingText = {
                    if (inputError != null) {
                        Text(inputError!!)
                    }
                }
            )

            fun requireNonEmptyText(): String? {
                val text = inputText.trim()
                return if (text.isEmpty()) {
                    inputError = "Поле не должно быть пустым"
                    null
                } else {
                    text
                }
            }

            fun requireValidPhone(): String? {
                val phone = inputText.trim()
                return when {
                    phone.isEmpty() -> {
                        inputError = "Введите номер телефона"
                        null
                    }
                    !Patterns.PHONE.matcher(phone).matches() -> {
                        inputError = "Некорректный номер телефона"
                        null
                    }
                    else -> phone
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val text = requireNonEmptyText() ?: return@Button

                    val intent = Intent(context, SecondActivity::class.java).apply {
                        putExtra(MainActivity.EXTRA_TEXT, text)
                    }
                    context.startActivity(intent)
                }
            ) {
                Text("Открыть вторую Activity")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val phone = requireValidPhone() ?: return@Button

                    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:${Uri.encode(phone)}")
                    }

                    if (dialIntent.resolveActivity(context.packageManager) == null) {
                        inputError = "На устройстве нет приложения «Телефон»"
                        return@Button
                    }

                    context.startActivity(dialIntent)
                }
            ) {
                Text("Позвонить другу")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val text = requireNonEmptyText() ?: return@Button

                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, text)
                    }

                    val chooser = Intent.createChooser(shareIntent, "Поделиться через…")

                    if (shareIntent.resolveActivity(context.packageManager) == null) {
                        inputError = "Нет приложений для отправки текста"
                        return@Button
                    }

                    context.startActivity(chooser)
                }
            ) {
                Text("Поделиться текстом")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}