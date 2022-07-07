package com.example.marvelapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentMarvelListBinding
import com.example.marvelapp.model.ResultModel
import com.example.marvelapp.utils.Response



class MarvelListFragment : ViewModelFragment() {

    private var _binding: FragmentMarvelListBinding? = null
    private val binding: FragmentMarvelListBinding get() = _binding!!

//    private val binding by lazy{
//        FragmentMarvelListBinding.inflate(layoutInflater)
//    }

    private lateinit var recyclerViewAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMarvelListBinding.inflate(layoutInflater)


        configureObserver()
        return binding.root
    }

    private fun configureObserver() {
        viewModel.marvelLiveData.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Response.Loading -> {
                    binding.apply {
                        recyclerview.visibility = View.GONE
                    }
                }
                is Response.Success -> {
                    binding.apply {
                        recyclerview.visibility = View.VISIBLE
                        tvError.visibility=View.GONE
                        progressBar.visibility= View.GONE
                    }

                    state.data?.let {
                        recyclerViewAdapter = MainAdapter(openDetail = ::openDetails)
                        binding.recyclerview.layoutManager=LinearLayoutManager(context)
                        binding.recyclerview.adapter = recyclerViewAdapter
                        recyclerViewAdapter.setList( it.data.results)
//
//                        Toast.makeText(
//                            requireContext(),
//                            "Success Data" + it.data.results.toString(),
//                            Toast.LENGTH_LONG
//                        ).show()

                    }
                }
                is Response.Error -> {

                    binding.tvError.text= state.errorMsg.toString()

                }


            }


        })
    }

    private fun openDetails(resultModel: ResultModel){
        parentFragmentManager.beginTransaction()
            .replace(R.id.List_container,MarvelDetailsFragment.newInstance(resultModel))
            .addToBackStack(null)
            .commit()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MarvelListFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

