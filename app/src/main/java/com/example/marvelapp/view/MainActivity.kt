package com.example.marvelapp.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.marvelapp.R
import com.example.marvelapp.viewmodel.MarvelViewModel

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       // val fragment = MarvelListFragment()
//        val fragmentManager: FragmentManager = supportFragmentManager
//        fragmentManager.beginTransaction().replace(R.id.List_container, fragment).commit()

    }


}