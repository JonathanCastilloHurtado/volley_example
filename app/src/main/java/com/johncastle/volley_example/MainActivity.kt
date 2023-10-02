package com.johncastle.volley_example

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.johncastle.bolley_example.R
import org.json.JSONObject


var textView: TextView? =null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)
        val url_get = "https://www.johncastle.com.mx/apis/get_book.php"
        val url_post = "https://www.johncastle.com.mx/apis/api_post.php"
        postVolley(url_post)
        //getVolley(url_get)

    }

    fun getVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                textView!!.text = "Response is: ${response}"
            },
            Response.ErrorListener { textView!!.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
    fun postVolley(url: String) {

        val requestBody= JSONObject()
        requestBody.put("correo_electronico","johncastle@example.com")
        requestBody.put("psw","123")

        val que = Volley.newRequestQueue(this)
        val req = JsonObjectRequest(
            Request.Method.POST,url,requestBody,
            Response.Listener {
                    response ->
                textView!!.text = "Response is: ${response}"
            }, Response.ErrorListener {
                textView!!.text = "That didn't work!"
            }
        )
        que.add(req)
    }
}