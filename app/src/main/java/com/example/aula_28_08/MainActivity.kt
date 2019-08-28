package com.example.aula_28_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = readJSONFromAsset()
        val type = object: TypeToken<List<Book>>(){}.type

        val book = Gson().fromJson<List<Book>>(json, type)

        val layoutManeger = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManeger
        val adpter = BooksAdapter()
        recyclerView.adapter = adpter
        adpter.submitList(book)
    }

    private fun readJSONFromAsset(): String?{
        var json:String?
        try{
            val inputStream:InputStream = assets.open("books.json")
            json = inputStream.bufferedReader().use {it.readText()}
        }
        catch (ex:Exception){
            ex.printStackTrace()
            return null
        }
        return json
    }
}
