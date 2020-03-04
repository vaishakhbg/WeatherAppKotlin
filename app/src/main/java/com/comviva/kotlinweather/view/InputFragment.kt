package com.comviva.kotlinweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.comviva.kotlinweather.R
import com.comviva.kotlinweather.viewModel.WeatherViewModel
import com.comviva.kotlinweather.databinding.InputfragmentBinding

class InputFragment:Fragment() {

    companion object{
        fun newInstance():InputFragment{
            return InputFragment()
        }
    }
    private  lateinit var  weatherViewModel: WeatherViewModel
    private lateinit var inputfragmentBinding: InputfragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherViewModel=ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inputfragmentBinding=DataBindingUtil.inflate(inflater,R.layout.inputfragment,container,false)
        inputfragmentBinding.viewmodel=weatherViewModel
        return inputfragmentBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        inputfragmentBinding.executePendingBindings()
    }
}