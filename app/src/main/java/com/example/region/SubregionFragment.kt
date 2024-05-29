package com.example.region

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class SubregionFragment : Fragment(R.layout.fragment_subregion) {
    private lateinit var viewModel: CountryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CountryViewModel::class.java)

        val subregionAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1)
        view.findViewById<ListView>(R.id.subregion_list).adapter = subregionAdapter

        viewModel.subregions.observe(viewLifecycleOwner, Observer {
            subregionAdapter.clear()
            subregionAdapter.addAll(it)
            subregionAdapter.notifyDataSetChanged()
        })

        view.findViewById<ListView>(R.id.subregion_list).setOnItemClickListener { _, _, position, _ ->
            val selectedSubregion = subregionAdapter.getItem(position) ?: return@setOnItemClickListener
            viewModel.fetchCountriesBySubregion(selectedSubregion)
            findNavController().navigate(R.id.action_subregionFragment_to_countryFragment)
        }
    }
}
