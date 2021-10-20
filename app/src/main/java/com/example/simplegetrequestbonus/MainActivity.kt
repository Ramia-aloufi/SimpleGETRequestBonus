package com.example.simplegetrequestbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        GetNames()
    }

    fun GetNames(){
        var names = ""
        val apiInterfac = Constants.apiInterface
        if (apiInterfac!=null) {
            apiInterfac.getNames()?.enqueue(object : retrofit2.Callback<Item> {
                override fun onResponse(call: Call<Item>, response: Response<Item>) {
                    var item = response.body()
                    if (item != null) {
                        for (i in 0 until item.size) {
                            var name = item[i].name
                            names += "$name\n"
                            Log.d("names", name)


                        }
                        tv.text = names
                    }
                }

                override fun onFailure(call: Call<Item>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })



        }
    }
}