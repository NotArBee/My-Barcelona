package com.ardev.barcelona

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPlayerAdapter(private val listPlayer: ArrayList<Player_Identity>) :
    RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.player_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPlayer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, position, desc, photo, special) = listPlayer[position]
        holder.playerName.text = name
        holder.playerPosition.text = position
        holder.playerDesc.text = desc
        holder.playerPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, PlayerDetailActivity::class.java)
            intentDetail.putExtra("key_player", listPlayer[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.playerName)
        val playerPosition: TextView = itemView.findViewById(R.id.playerPosition)
        val playerDesc: TextView = itemView.findViewById(R.id.playerDesc)
        val playerPhoto: ImageView = itemView.findViewById(R.id.playerPhoto)
    }
}