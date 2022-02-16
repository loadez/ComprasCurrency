package dev.loadez.comprascurrency

import android.os.AsyncTask
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.net.URL

class CalculateTask(resultActivity: ResultActivity) : AsyncTask<Float, Boolean, Float>() {
    private val resultActivity:ResultActivity = resultActivity


    override fun onPostExecute(result: Float) {
        super.onPostExecute(result)
        resultActivity.requestCompleted(result)
    }

    override fun doInBackground(vararg params: Float?): Float {
        return try {
            val url = URL("https://blockchain.info/ticker")
            val text = url.readText()
            try {
                val json = JSONObject(text)
                val buyPrice = json.getJSONObject("BRL").getDouble("buy")
                params[0]!! * buyPrice.toFloat()
            } catch (ex: JSONException) {
                Float.NaN
            }
        } catch (ex:Exception){
            Log.d("Error", ex.toString())
            Float.NaN
        }
    }

}