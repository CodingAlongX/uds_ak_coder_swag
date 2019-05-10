package pro.smjx.coderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pro.smjx.coderswag.R
import pro.smjx.coderswag.adapters.CategoryAdapter
import pro.smjx.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(
            this,
            DataService.categories
        )

        categoryListView.adapter = adapter

        categoryListView.setOnItemClickListener { adapterView, view, position, id ->
            val category = DataService.categories[position]

            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
        }
    }
}
