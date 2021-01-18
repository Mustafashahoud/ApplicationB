package com.android.mustafa.applicationb.feature.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.android.mustafa.applicationb.R
import com.android.mustafa.applicationb.core.ui.adapter.DataBoundListAdapter
import com.android.mustafa.applicationb.databinding.NotificationItemBinding

class NotificationListAdapter(
    private val movieOnClickCallback: ((Notification) -> Unit)?
) : DataBoundListAdapter<Notification, NotificationItemBinding>(
    diffCallback = object : DiffUtil.ItemCallback<Notification>() {
        override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun createBinding(parent: ViewGroup): NotificationItemBinding {
        val binding = DataBindingUtil.inflate<NotificationItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.notification_item,
            parent,
            false
        )
        binding.root.setOnClickListener {
            binding.notification?.let {
                movieOnClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: NotificationItemBinding, item: Notification) {
        binding.notification = item
    }
}