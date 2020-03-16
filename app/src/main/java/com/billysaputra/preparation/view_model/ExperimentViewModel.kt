package com.billysaputra.preparation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.billysaputra.preparation.connection.ConnectionCallback
import com.billysaputra.preparation.connection.ConnectionManager
import com.billysaputra.preparation.connection.RetrofitService
import com.billysaputra.preparation.data.model.MovieItem
import com.billysaputra.preparation.data.model.MovieResponse
import com.billysaputra.preparation.helper.Constants
import retrofit2.Call
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class ExperimentViewModel : ViewModel(){
    private val movieList = MutableLiveData<ArrayList<MovieItem>>()
    var retrofitOnFailure = MutableLiveData<Boolean?>()

    internal fun setMovie() {
        /*val langCode = if (Locale.getDefault().language == "in") "id" else Locale.getDefault().language

        val requestMovie : Call<MovieResponse> = RetrofitService.request.getMovie(Constants.API_KEY,langCode)
        val connectionManager = ConnectionManager()
        connectionManager.connect(requestMovie, object : ConnectionCallback {
            override fun onResponse(call: Call<*>, response: Response<*>) {
                val movieResponse = response.body() as MovieResponse
                movieList.postValue(movieResponse.results)
            }

            override fun onFailure(call: Call<*>) {
                retrofitOnFailure.value = true
            }
        })*/
    }

    internal fun getMovie(): LiveData<ArrayList<MovieItem>> {
        return movieList
    }
}