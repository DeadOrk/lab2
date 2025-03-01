package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.calculateButton).setOnClickListener {

            val nStr = findViewById<EditText>(R.id.nInput).text.toString()
            if (nStr.isEmpty()) {
                Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show()
            }

            val n = nStr.toIntOrNull() ?: 0
            if (n < 1) {
                Toast.makeText(this, "Число должно быть натуральным!", Toast.LENGTH_SHORT).show()
            }

            var Sum = 0.0
            for (k in 1..n) {
                var denominator = 0.0
                for (i in 1..k) {
                    denominator += sin(i.toDouble())
                }

                if (denominator == 0.0) {
                    Toast.makeText(this, "Ошибка: деление на ноль", Toast.LENGTH_SHORT).show()
                }

                Sum += 1.0 / denominator
            }

            findViewById<TextView>(R.id.resultTextView).text =
                "Результат: ${"%.4f".format(Sum)}"

        }

    }
}