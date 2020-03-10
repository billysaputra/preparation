package com.billysaputra.preparation.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.billysaputra.preparation.R

class SampleFragment : Fragment() {

    private lateinit var mContext: Context
    private var argument = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            argument = it.getString(ARG_PARAM1, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    companion object {
        const val ARG_PARAM1 = "ARG_PARAM1"
        @JvmStatic
        fun newInstance(param1: String) =
            SampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
