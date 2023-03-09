package com.e.terremoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TerremotoAdapter:ListAdapter<Terremoto,TerremotoAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val idTerremoto:TextView=view.findViewById(R.id.itemID)
        val nameTerremoto:TextView=view.findViewById(R.id.itemLugar)
        val magnitudeTerremoto:TextView=view.findViewById(R.id.itemMagnitud)
        val otherTerremoto:TextView=view.findViewById(R.id.itemOther)

        fun onBind(earthQuake:Terremoto){
            idTerremoto.text=earthQuake.id
            nameTerremoto.text=earthQuake.name
            magnitudeTerremoto.text=earthQuake.magnitud.toString()
            otherTerremoto.text=earthQuake.other
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myView:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val earthQuakePos= getItem(position)
        holder.onBind(earthQuakePos)

    }


    companion object DiffCallBack : DiffUtil.ItemCallback<Terremoto>() {
        override fun areItemsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem == newItem
        }
    }
}

