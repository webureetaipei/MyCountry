package com.example.region

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegionFragment : Fragment(R.layout.fragment_region) {
    private lateinit var viewModel: CountryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CountryViewModel::class.java)

        view.findViewById<Button>(R.id.button_asia).setOnClickListener {
            viewModel.fetchCountriesByRegion("asia")
            findNavController().navigate(R.id.action_regionFragment_to_subregionFragment)
        }

        view.findViewById<Button>(R.id.button_europe).setOnClickListener {
//            viewModel.fetchCountriesByRegion("europe")
//            findNavController().navigate(R.id.action_regionFragment_to_subregionFragment)
        }

        view.findViewById<Button>(R.id.button_americas).setOnClickListener {
//            viewModel.fetchCountriesByRegion("americas")
//            findNavController().navigate(R.id.action_regionFragment_to_subregionFragment)
        }
    }
}
