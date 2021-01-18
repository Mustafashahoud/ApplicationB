package com.android.mustafa.applicationb.feature.notifications

data class Notification(
    val id: Long,
    val title: String,
    val message: String,
    val category: Category,
    val time: String
)

enum class Category {
    SOCIAL,
    OTHER
}

