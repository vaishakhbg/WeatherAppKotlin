package com.comviva.kotlinweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.comviva.kotlinweather.view.InputFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framee,InputFragment()).commit()
    }
}
