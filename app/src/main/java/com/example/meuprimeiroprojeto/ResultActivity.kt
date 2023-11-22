package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //Botão de voltar
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult: TextView = findViewById(R.id.tv_Result)
        val tvClassificacao: TextView = findViewById(R.id.tv_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()


        var classificacao = if(result <=  18.5f){
             " ABAIXO DO PESO"
        } else if(result in 18.5f..24.9f) {
             " NORMAL"
        } else if(result > 24.9f && result <= 29.9f){
              " SOBREPESO"
        } else{
             " OBESO"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    //Para ativar o botão de voltar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}