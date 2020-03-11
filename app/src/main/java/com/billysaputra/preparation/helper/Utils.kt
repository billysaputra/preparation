package com.billysaputra.preparation.helper

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.IOException
import java.io.InputStream

/**
 * Created by Billy Saputra on 2020-03-10.
 */
object Utils {
    fun glideRequestOptions(placeholder: Int): RequestOptions {
        return RequestOptions()
            .placeholder(placeholder)
            .error(placeholder)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .dontAnimate()
            .dontTransform()
    }

    fun inputStreamToString(inputStream: InputStream): String? {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            null
        }
    }
}