package com.cheise_proj.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cheise_proj.dashboard.R
import com.cheise_proj.dashboard.model.DashboardMenu
import kotlinx.android.synthetic.main.menu_items.view.*

class DashboardAdapter(private val onItemClick: (DashboardMenu?) -> Unit={} ) :
    ListAdapter<DashboardMenu, DashboardAdapter.DashboardVh>(DashboardDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardVh {

        return DashboardVh(
            LayoutInflater.from(parent.context).inflate(R.layout.menu_items, parent, false)

        )
    }

    override fun onBindViewHolder(holder: DashboardVh, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }


    class DashboardVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: DashboardMenu?,
            onItemClick: (DashboardMenu?) -> Unit
        ) {
            with(itemView) {
                item_name.text = item?.title
                item_img.setImageDrawable(item?.image)
                this.setOnClickListener { onItemClick(item) }
            }
        }
    }
}

internal class DashboardDiff : DiffUtil.ItemCallback<DashboardMenu>() {
    override fun areItemsTheSame(oldItem: DashboardMenu, newItem: DashboardMenu): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: DashboardMenu, newItem: DashboardMenu): Boolean {
        return oldItem == newItem
    }
}