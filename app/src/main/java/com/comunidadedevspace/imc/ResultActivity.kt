package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC";

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        window.apply {
            statusBarColor = ContextCompat.getColor(this@ResultActivity, R.color.primary_900)
        }

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f);
        val tvResult = findViewById<TextView>(R.id.tv_result);
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao);

        tvResult.text = result.toString();

        val classificacao: String;
        val color: Int;

        if(result < 18.5) {
            classificacao = "MAGREZA";
            color = R.color.red;
        }
        else if(result < 25) {
            classificacao = "NORMAL";
            color = R.color.green;
        }
        else if(result < 30) {
            classificacao = "SOBREPESO";
            color = R.color.yellow;
        }
        else if(result < 40) {
            classificacao = "OBESIDADE";
            color = R.color.red;
        }
        else {
            classificacao = "OBESIDADE GRAVE"
            color = R.color.red;
        }

        tvClassificacao.text = classificacao;
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color));
    }
}