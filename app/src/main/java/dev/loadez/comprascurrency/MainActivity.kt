package dev.loadez.comprascurrency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val text:String = findViewById<TextView>(R.id.editTextNumber).text.toString()
            val value: Double? = text.toDoubleOrNull()

            if(value!=null){
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("value",value)
                startActivity(intent)
            }
        }
    }
}