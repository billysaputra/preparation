package com.billysaputra.preparation.data

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {
    const val AUTHORITY = "com.billysaputra.preparation"
    const val SCHEME = "content"

    class SampleColumn : BaseColumns {

        companion object {
            const val TABLE_NAME = "home_table"
            const val ID = "id"
            const val NAME = "name"
            const val IMAGES = "images"
            const val CONTENT_TYPE = "content_type"

            // untuk membuat URI content://com.billysaputra.preparation/componentId
            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}