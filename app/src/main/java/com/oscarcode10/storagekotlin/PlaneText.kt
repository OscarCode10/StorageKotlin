package com.oscarcode10.storagekotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class PlaneText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plane_text)
        val data = findViewById<EditText>(R.id.Mercado)
        val save = findViewById<Button>(R.id.saveMercado)
        if (fileList().contains("data.txt")){
            try {
                val file = InputStreamReader(openFileInput("data.txt"))
                val reader = BufferedReader(file)
                var line = reader.readLine()
                val contentTotal = StringBuffer()
                while (line != null){
                    contentTotal.append(line + "\n")
                    line = reader.readLine()
                }
                reader.close()
                file.close()
                data.setText(contentTotal)
            }
            catch (e: IOException){

            }
        }
        save.setOnClickListener {
            try{
                val file = OutputStreamWriter(openFileOutput("data.txt", Activity.MODE_PRIVATE))
                file.write(data.text.toString())
                file.flush()
                file.close()
            }
            catch (e: IOException){

            }
            Toast.makeText(this, "Elemento agregado", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}