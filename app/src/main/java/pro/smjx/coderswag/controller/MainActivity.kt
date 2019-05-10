package pro.smjx.coderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pro.smjx.coderswag.R
import pro.smjx.coderswag.adapters.CategoryAdapter
import pro.smjx.coderswag.adapters.CategoryRecyclerAdapter
import pro.smjx.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(
            this,
            DataService.categories
        )

        categoryRecyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryRecyclerView.layoutManager = layoutManager
        categoryRecyclerView.setHasFixedSize(true)

    }
}
