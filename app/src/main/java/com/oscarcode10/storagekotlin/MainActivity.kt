package com.oscarcode10.storagekotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = findViewById<EditText>(R.id.editTextName)
        val data = findViewById<EditText>(R.id.editTextData)
        val save = findViewById<Button>(R.id.save)
        val select = findViewById<Button>(R.id.select)
        val preferences= getSharedPreferences("agenda", Context.MODE_PRIVATE)
        save.setOnClickListener {
            val editar = preferences.edit()
            editar.putString(name.text.toString(),data.text.toString())
            editar.commit()
            Toast.makeText(this, "Contacto agreado", Toast.LENGTH_SHORT).show()
        }
        select.setOnClickListener {
            val selectData = preferences.getString(name.text.toString(),"")
            if (selectData != null){
                if(selectData.length == 0 ){
                    Toast.makeText(this, "Contacto no encontrado", Toast.LENGTH_SHORT).show()
                }
                else{
                    data.setText(selectData);
                }
            }
        }

    }
}