package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtPeso: EditText = findViewById(R.id.edtPeso)
        val edtAlt: EditText = findViewById(R.id.edtAlt)
       // val tvResultado: TextView = findViewById(R.id.txtMsg)

        btnCalculate.setOnClickListener {

            //Correção de erro campo vazio
            val alturaStr = edtAlt.text.toString()
            val pesoStr = edtPeso.text.toString()

            val altura: Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()

        if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
            var alturaCalculo: Float = altura * altura
            var pesoFinal: Float = peso
            var resultado: Float = pesoFinal / alturaCalculo

            //tvResultado.text = resultado.toString()


            //Para mudar de tela.
            val intent = Intent(this, ResultActivity::class.java)
            //Para levar um dado extra para a próxima tela.
            .apply {
                putExtra("EXTRA_RESULT", resultado)
            }
            startActivity(intent)
        } else{
            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
        }

    }
}
}