package com.example.marvelapp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.marvelapp.databinding.FragmentMarvelDetailsBinding
import com.example.marvelapp.model.ResultModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MarvelDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MarvelDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMarvelDetailsBinding? = null
    private val binding: FragmentMarvelDetailsBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMarvelDetailsBinding.inflate(layoutInflater)
        val resultModel: ResultModel = arguments?.get("result") as ResultModel

        binding.tvDetailDescription.text = resultModel.description
        val url = resultModel.thumbnail.getImage()
        val image = url.replace("http", "https")
        Glide.with(binding.ivDetail).load(image).into(binding.ivDetail)
        binding.tvDetailName.text = resultModel.name
        binding.tvComic.text = resultModel.comics.items[0].name

        var urlText = resultModel.resourceURI+"&apikey=678c0bb6d6aea2fbde954e9c8e170586&hash=6c5502e0089e46828d91a0d16149b185"
        binding.tvResourceURI.text = resultModel.resourceURI
        binding.tvResourceURI.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urlText))
            startActivity(browserIntent)
        }
        binding.tvStories.text = resultModel.stories.items[0].name
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MarvelDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(result: ResultModel) =
            MarvelDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("result", result)

                }
            }
    }
}