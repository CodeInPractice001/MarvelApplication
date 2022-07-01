package com.example.marvelapp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.marvelapp.viewmodel.MarvelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class ViewModelFragment: Fragment() {
    protected val viewModel: MarvelViewModel by activityViewModels()
}