package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra("imc_result", 0.1f)

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResultado.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25f..29.9f) {
            "SOBREPESO"
        } else if (result in 30f..39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao

        val cor = when (classificacao) {
            "ABAIXO DO PESO" -> ContextCompat.getColor(this, R.color.color_underweight)
            "NORMAL" -> ContextCompat.getColor(this, R.color.color_normal)
            "SOBREPESO" -> ContextCompat.getColor(this, R.color.color_overweight)
            "OBESIDADE" -> ContextCompat.getColor(this, R.color.color_obesity)
            "OBESIDADE GRAVE" -> ContextCompat.getColor(this, R.color.color_severe_obesity)
            else -> ContextCompat.getColor(this, R.color.black) // Cor padrão
        }

        tvClassificacao.setTextColor(cor)
    }
}
