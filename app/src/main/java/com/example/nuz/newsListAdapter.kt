package com.example.nuz

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newsListAdapter(private val listener:newsItemClicked): RecyclerView.Adapter<newsViewHolder>() {

  private val items:ArrayList<News> = ArrayList()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHolder {
   val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
   val viewHolder=newsViewHolder(view)
   view.setOnClickListener {
    listener.onItemClicked(items[viewHolder.adapterPosition])
   }
   return viewHolder
  }

  override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
   val current=items[position]
   holder.titleView.text=current.title
   holder.author.text=current.author
   Glide.with(holder.itemView.context).load(current.imageUrl).into(holder.imageView)

  }

  override fun getItemCount(): Int {
   return items.size
  }

  fun updateNews(updates :ArrayList<News>)
  {
   items.clear()
   items.addAll(updates)

   notifyDataSetChanged()
  }

 }

class newsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val titleView:TextView=itemView.findViewById(R.id.title)
 val imageView:ImageView=itemView.findViewById(R.id.image)
 val author:TextView=itemView.findViewById(R.id.authorName)
}

interface newsItemClicked{
 fun onItemClicked(item:News)
 {

 }
}