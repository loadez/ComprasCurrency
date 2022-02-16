package dev.loadez.comprascurrency

import android.os.AsyncTask
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.net.URL

class CalculateTask(resultActivity: ResultActivity) : AsyncTask<Double, Boolean, Double>() {
    private val resultActivity:ResultActivity = resultActivity


    override fun onPostExecute(result: Double) {
        super.onPostExecute(result)
        resultActivity.requestCompleted(result)
    }

    override fun doInBackground(vararg params: Double?): Double {
        return try {
            val url = URL("https://blockchain.info/ticker")
            val text = url.readText()
            try {
                val json = JSONObject(text)
                val buyPrice = json.getJSONObject("BRL").getDouble("buy")
                params[0]!! * buyPrice
            } catch (ex: JSONException) {
                Double.NaN
            }
        } catch (ex:Exception){
            Log.d("Error", ex.toString())
            Double.NaN
        }
    }

}