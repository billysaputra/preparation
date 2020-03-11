package com.billysaputra.preparation.data.content_provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.billysaputra.preparation.data.DatabaseContract.AUTHORITY
import com.billysaputra.preparation.data.DatabaseContract.SCHEME
import com.billysaputra.preparation.data.DatabaseContract.SampleColumn.Companion.TABLE_NAME
import com.billysaputra.preparation.data.SampleDatabase

class SampleContentProvider : ContentProvider(){

    companion object{
        private const val HOME = 1
        private const val HOME_COMPONENT_ID = 2
        private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        private lateinit var sampleDatabase: SampleDatabase
        var URI_HOME = Uri.parse("$SCHEME://$AUTHORITY/$TABLE_NAME")

        init{
            // content://com.billysaputra.preparation/home_table
            sUriMatcher.addURI(AUTHORITY, TABLE_NAME, HOME_COMPONENT_ID)
            // content://com.billysaputra.movie/movie_table/movie_id
            sUriMatcher.addURI(
                AUTHORITY,
                "$TABLE_NAME/#",
                HOME_COMPONENT_ID
            )
        }
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        val cursor: Cursor?
        when (sUriMatcher.match(uri)) {
            HOME -> {
                cursor = sampleDatabase.sampleDao().getHomeComponentCursor()
                cursor.setNotificationUri(context.contentResolver, uri)
            }
            HOME_COMPONENT_ID -> cursor =
                sampleDatabase.sampleDao().getHomeComponentById(uri.lastPathSegment.toString().toInt())
            else -> cursor = null
        }
        return cursor
    }

    override fun onCreate(): Boolean {
        sampleDatabase = SampleDatabase.getDatabase(context)
        return true
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<String>?): Int {
        return 0
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<String>?): Int {
        /*val deleted: Int = when (MOVIE_ID) {
             sUriMatcher.match(uri) -> sampleDatabase.sampleDao().deleteHomeComponentById(uri.lastPathSegment.toString().toInt())
             else -> 0
         }
         context?.contentResolver?.notifyChange(CONTENT_URI, null)
         return deleted*/
        return 0
    }

    override fun getType(p0: Uri): String? {
        return null
    }
}