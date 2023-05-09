package com.sportz.cricketnews.presentation.teamdetail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sportz.cricketnews.data.model.Players
import com.sportz.cricketnews.databinding.TeamRecycletItemBinding

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 09-05-2023
 */
class PlayerRecyclerAdapter(
    val playersArrayList: ArrayList<Players>,
    val itemClickListener: onItemClickListener
) : RecyclerView.Adapter<PlayerRecyclerAdapter.PlayerViewHolder>(){
    inner class PlayerViewHolder(val binding: TeamRecycletItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    interface onItemClickListener{
        fun onClick(players: Players)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = TeamRecycletItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
       val players = playersArrayList.get(position)
        val playerName = players.nameFull
        if(players.isCaptain){
            holder.binding.tvPlayerName.text = "$playerName (C)"
        }else if(players.isKeeper){
            holder.binding.tvPlayerName.text = "$playerName (Wk)"
        }else{
            holder.binding.tvPlayerName.text = playerName
        }
        Log.i("livedata",players.isCaptain.toString())
        holder.binding.tvPlayerName.setOnClickListener{
            itemClickListener.onClick(players)
        }
    }

    override fun getItemCount(): Int {
       return playersArrayList.size
    }
}