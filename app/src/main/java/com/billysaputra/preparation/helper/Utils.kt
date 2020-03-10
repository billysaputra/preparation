package com.billysaputra.preparation.helper

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

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
}