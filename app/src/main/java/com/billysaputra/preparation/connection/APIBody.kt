package com.billysaputra.preparation.connection

import com.billysaputra.preparation.helper.Constants

/**
 * Created by Billy Saputra on 2020-03-10.
 */
object APIBody {

    fun getSomeDataBodyRequest(body1 : String, body2 : String) : Map<String, String>{
        val body = HashMap<String, String>()
        body[Constants.RequestBody.BODY_1] = body1
        body[Constants.RequestBody.BODY_2] = body2
        return body
    }
}