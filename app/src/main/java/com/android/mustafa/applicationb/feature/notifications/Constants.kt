package com.android.mustafa.applicationb.feature.notifications

import android.net.Uri
import android.provider.BaseColumns

object Constants {

    /** The name of the ID column.  */
    const val COLUMN_ID = BaseColumns._ID

    /** The name of the title column.  */
    const val COLUMN_TITLE = "title"

    /** The name of the packageName column.  */
    const val COLUMN_PACKAGE_NAME = "packageName"

    /** The name of the message column.  */
    const val COLUMN_MESSAGE = "message"

    /** The name of the importance column.  */
    const val COLUMN_IMPORTANCE = "importance"

    /** The name of the time column.  */
    const val COLUMN_TIME = "time"

    /** The authority of this content provider.  */
    private const val AUTHORITY = "com.android.mustafa.applicationa.provider"

    private  const val TABLE_NAME = "notifications"

    const val LOADER_NOTIFICATION = 1

    /** The URI for the notifications table.  */
    val URI_NOTIFICATION: Uri = Uri.parse(
        "content://$AUTHORITY/$TABLE_NAME"
    )
}