package com.android.mustafa.applicationb.feature.notifications

import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mustafa.applicationb.core.util.TimeUtils
import com.android.mustafa.applicationb.databinding.ActivityMainBinding
import com.android.mustafa.applicationb.feature.notifications.Constants.COLUMN_ID
import com.android.mustafa.applicationb.feature.notifications.Constants.COLUMN_IMPORTANCE
import com.android.mustafa.applicationb.feature.notifications.Constants.COLUMN_MESSAGE
import com.android.mustafa.applicationb.feature.notifications.Constants.COLUMN_PACKAGE_NAME
import com.android.mustafa.applicationb.feature.notifications.Constants.COLUMN_TIME
import com.android.mustafa.applicationb.feature.notifications.Constants.COLUMN_TITLE
import com.android.mustafa.applicationb.feature.notifications.Constants.LOADER_NOTIFICATION
import com.android.mustafa.applicationb.feature.notifications.Constants.URI_NOTIFICATION

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: NotificationListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()

        LoaderManager.getInstance(this)
            .initLoader(LOADER_NOTIFICATION, null, mLoaderCallbacks)

    }

    private val mLoaderCallbacks = object : LoaderManager.LoaderCallbacks<Cursor> {
        override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
            return CursorLoader(
                applicationContext,
                URI_NOTIFICATION,
                arrayOf(
                    COLUMN_ID, COLUMN_TITLE, COLUMN_PACKAGE_NAME,
                    COLUMN_MESSAGE, COLUMN_IMPORTANCE, COLUMN_TIME
                ),
                null,
                null,
                null
            )
        }

        override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
            val result = getNotifications(data)
            submitData(result)

        }

        override fun onLoaderReset(loader: Loader<Cursor>) {
            submitData(null)
        }

    }

    private fun submitData(data: List<Notification>?) {
        adapter.submitList(data)
    }

    private fun initAdapter() {
        adapter = NotificationListAdapter { /*Do nothing for now **/ }
        binding.notificationsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.notificationsRecyclerView.adapter = adapter
    }


    private fun getNotifications(cursor: Cursor?): List<Notification> {
        val result: MutableList<Notification> = mutableListOf()
        cursor?.let {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                result.add(
                    Notification(
                        id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)),
                        message = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MESSAGE)),
                        time = TimeUtils.getTimeInTimeAgoPattern(
                            cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_TIME))
                        ),
                        category = NotificationUtils.getNotificationCategory(
                            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PACKAGE_NAME))
                        )
                    )
                )
                cursor.moveToNext()
            }
        }
        return result.toList()
    }
}