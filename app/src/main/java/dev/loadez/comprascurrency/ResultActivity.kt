package dev.loadez.comprascurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.net.URL

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val value = intent.getFloatExtra("value",0f)

        val task = CalculateTask(this)
        task.execute(value)


    }

    fun requestCompleted(value:Float){
        findViewById<TextView>(R.id.textView).text = if (value.isNaN()) "Erro ao acessar a API" else value.toString()
        Log.d("TAG", "$value")
    }
}