package com.example.rodrigo.projetoandroidturma2

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DicaActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dica)

        val selected: String = intent.getStringExtra("selected")
        val buttonBackDica = findViewById<Button>(R.id.button_back_dica)
        var text = findViewById<TextView>(R.id.text_dica).setText(selected)

        buttonBackDica.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


