package zaqiealfatah.gmail.workshop12

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
//menampilkan gambar dari internet

class RecyclerViewAdapter (private val context: Context, private val items: List<Item>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, p0, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(items[p1])
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder (view) {
        private val name = view.findViewById<TextView>(R.id.club_name)
        private val image = view.findViewById<ImageView>(R.id.club_logo)

        fun bindItems(item: Item) {
            name.text = item.name
            Glide.with(itemView.context).load(item.image).into(image)
        }
    }
}