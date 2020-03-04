package com.comviva.kotlinweather.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.comviva.kotlinweather.R
import com.comviva.kotlinweather.viewModel.WeatherViewModel
import com.comviva.kotlinweather.databinding.WeatherfragmentBinding

class WeatherFragment: Fragment() {
    companion object{
        fun newInstance():WeatherFragment{
            return WeatherFragment()
        }
    }

    private lateinit var weatherViewModel:WeatherViewModel

    private lateinit var weatherfragmentBinding: WeatherfragmentBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherViewModel=ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        weatherfragmentBinding=DataBindingUtil.inflate(inflater,R.layout.weatherfragment,container,false)
        weatherfragmentBinding.viewmodel=weatherViewModel
        return weatherfragmentBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        weatherfragmentBinding.executePendingBindings()

    }
}