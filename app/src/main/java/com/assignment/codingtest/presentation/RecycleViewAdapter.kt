package com.assignment.codingtest.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.assignment.codingtest.data.Model.Asset
import com.assignment.codingtest.R
import kotlinx.android.synthetic.main.asset_item_row.view.*

class RecycleViewAdapter(val assetList: List<Asset>, private val listener: OnItemClickListener) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.asset_item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return assetList.size
    }

    override fun onBindViewHolder(holder: RecycleViewAdapter.ViewHolder, position: Int) {
        holder.bindItems(assetList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        fun bindItems(asset: Asset) {

                itemView.container.textViewHeadLine.text = asset.headline
                itemView.container.textViewAbstract.text = asset.theAbstract
                itemView.container.textViewByLine.text = asset.byLine

        }

        override fun onClick(view: View?) {

            listener.onClick(view, adapterPosition)

        }
    }

    interface OnItemClickListener {
        fun onClick(view: View?, position: Int)
    }
}