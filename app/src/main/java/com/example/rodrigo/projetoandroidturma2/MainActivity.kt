package com.example.rodrigo.projetoandroidturma2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.*



import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val buttonOpt = findViewById<Button>(R.id.button_options)
        val buttonClear = findViewById<Button>(R.id.button_clean)
        val buttonDica = findViewById<Button>(R.id.button_dica)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val nameEdit = findViewById<EditText>(R.id.editText2)
        val intentDica = Intent(this, DicaActivity::class.java)
       // val radioButton = findViewById<RadioButton>(R.id.radio_group)

        buttonOpt.setOnClickListener {

            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)

        }
        buttonClear.setOnClickListener {

            nameEdit.setText("")
            val radioGroupClear = findViewById<RadioGroup>(R.id.radio_group)
            radioGroupClear.clearCheck()
        }
        buttonDica.setOnClickListener {

            val selected = radioGroup.checkedRadioButtonId
            val name = nameEdit.text
            if(selected == R.id.radio_occuped) intentDica.putExtra("selected","Parabens " + name)
            if(selected == R.id.radio_notbusy) intentDica.putExtra("selected", "Nao se preocupe " + name)
            if(selected == R.id.radio_unemployd) intentDica.putExtra("selected", "Vida boa " + name)
            startActivity(intentDica)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
