package com.udaychugh.newapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udaychugh.newapp.Adapter.viewHolder
import java.util.*

class Adapter(var context: Context, var modelClassArrayList: ArrayList<ModelClass>) : RecyclerView.Adapter<viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.cardView.setOnClickListener {
            val intent = Intent(context, webView::class.java)
            intent.putExtra("url", modelClassArrayList[position].url)
            context.startActivity(intent)
        }
        holder.mtime.text = "Published At:-" + modelClassArrayList[position].publishedAt
        holder.mauthor.text = modelClassArrayList[position].author
        holder.mheading.text = modelClassArrayList[position].title
        holder.mcontent.text = modelClassArrayList[position].description
        Glide.with(context).load(modelClassArrayList[position].urlToImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return modelClassArrayList.size
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mheading: TextView
        var mcontent: TextView
        var mauthor: TextView
        var mtime: TextView
        var cardView: CardView
        var imageView: ImageView

        init {
            mheading = itemView.findViewById(R.id.mainheading)
            mcontent = itemView.findViewById(R.id.content)
            mauthor = itemView.findViewById(R.id.author)
            mtime = itemView.findViewById(R.id.time)
            cardView = itemView.findViewById(R.id.cardview)
            imageView = itemView.findViewById(R.id.imageview)
        }
    }
}