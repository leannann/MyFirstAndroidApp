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
                onValueChange = { inputText = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Введите текст") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val text = inputText.trim()

                    if (text.isEmpty()) {
                        Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

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
                    val phone = inputText.trim()

                    if (phone.isEmpty()) {
                        Toast.makeText(context, "Введите номер телефона", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    if (!Patterns.PHONE.matcher(phone).matches()) {
                        Toast.makeText(context, "Некорректный номер телефона", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$phone")
                    }

                    if (dialIntent.resolveActivity(context.packageManager) == null) {
                        Toast.makeText(context, "Нет приложения для звонков", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    context.startActivity(dialIntent)
                }
            ) {
                Text("Позвонить другу")
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