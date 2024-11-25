package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f);
        val tvResult = findViewById<TextView>(R.id.tv_result);
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao);

        tvResult.text = result.toString();

        val classificacao: String = if(result < 18.5) {
           "MAGREZA";
        }
        else if(result < 25) {
            "NORMAL";
        }
        else if(result < 30) {
           "SOBREPESO";
        }
        else if(result < 40) {
           "OBESIDADE";
        }
        else {
           "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao;
    }
}