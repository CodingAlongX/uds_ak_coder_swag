package pro.smjx.coderswag.controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_products.*
import pro.smjx.coderswag.R
import pro.smjx.coderswag.adapters.ProductsAdapter
import pro.smjx.coderswag.services.DataService
import pro.smjx.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        val orientation = resources.configuration.orientation

        val screenSize = resources.configuration.screenWidthDp


        var spanCount = 2

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }


        if (screenSize > 720) {
            spanCount = 3
        }

        if (screenSize > 720 && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }

        val layoutManager = GridLayoutManager(this, spanCount)

        productsRecyclerView.layoutManager = layoutManager
        productsRecyclerView.adapter = adapter
    }
}
