package dev.loadez.comprascurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.net.URL

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val value = intent.getDoubleExtra("value",0.0)

        val task = CalculateTask(this)
        task.execute(value)

        findViewById<Button>(R.id.button2).setOnClickListener {
            finish()
        }

    }

    fun requestCompleted(value:Double){
        findViewById<TextView>(R.id.textView).text =
            if (value.isNaN())
                "Não foi possível acessar a api.\n" +
                    "Verifique sua conexão com a internet\n " +
                    "ou tente novamente em alguns minutos"
            else
                "Valor estimado da compra:\nR$ %f".format(value)
        Log.d("TAG", "$value")
    }
}