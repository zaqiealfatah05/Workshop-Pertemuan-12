package zaqiealfatah.gmail.workshop12

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items)
    }

    private fun initData() {
        val names = resources.getStringArray(R.array.club_name)
        val logos = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in names.indices){
            items.add(Item(names[i], logos.getResourceId(i, 0)))
        }
        logos.recycle()
    }
}
