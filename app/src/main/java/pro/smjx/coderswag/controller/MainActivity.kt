package pro.smjx.coderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import pro.smjx.coderswag.R
import pro.smjx.coderswag.model.Category
import pro.smjx.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_expandable_list_item_1,
            DataService.categories
        )

        categoryListView.adapter = adapter
    }
}
