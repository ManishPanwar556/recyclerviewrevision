package com.manish.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
lateinit var list:ArrayList<User>
    val adapter=rvadapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch{
           val response= withContext(Dispatchers.IO)
           {Client.api.getAllusers()}
            if(response.isSuccessful)
            {
               response.body()?.let {res:List<User>->
                   list.addAll(res)
                   runOnUiThread {
                       adapter.notifyDataSetChanged()
                   }
               }
            }
        }
        rv.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=this@MainActivity.adapter
        }



    }
}
