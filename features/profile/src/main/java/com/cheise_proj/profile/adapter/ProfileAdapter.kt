package com.cheise_proj.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cheise_proj.profile.R
import com.cheise_proj.profile.model.Profile
import kotlinx.android.synthetic.main.profile_items.view.*
import java.util.*

class ProfileAdapter :
    ListAdapter<Profile, ProfileAdapter.ProfileVh>(ProfileDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileVh {
        return ProfileVh(
            LayoutInflater.from(parent.context).inflate(R.layout.profile_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProfileVh, position: Int) {
        holder.bind(getItem(position))
    }

    class ProfileVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Profile) {
            with(itemView) {
                if (item.title.isEmpty()) return
                item_1.text = item.title.toUpperCase(Locale.getDefault())
                item_2.text = item.value
            }

        }
    }

    internal class ProfileDiff : DiffUtil.ItemCallback<Profile>() {
        override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem == newItem
        }
    }
}