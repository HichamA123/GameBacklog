package com.example.gamebacklog.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import kotlinx.android.synthetic.main.item_game.view.*
import java.time.ZoneId

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    lateinit var context : Context

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_game, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }


    inner class ViewHolder (itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(game: Game) {

            val localDate = game.releaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

            itemView.tvDate.text = localDate.toString()
            itemView.tvTitle.setText(game.title)
            itemView.tvPlatform.setText(game.platform)
        }
    }
}
