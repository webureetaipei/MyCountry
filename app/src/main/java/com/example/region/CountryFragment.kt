package com.example.region

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class CountryFragment : Fragment(R.layout.fragment_country) {
    private lateinit var viewModel: CountryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CountryViewModel::class.java)

        val countryAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1)
        view.findViewById<ListView>(R.id.country_list).adapter = countryAdapter

        viewModel.selectedSubregionCountries.observe(viewLifecycleOwner, Observer {
            countryAdapter.clear()
            countryAdapter.addAll(it.map { country -> country.name.common })
            countryAdapter.notifyDataSetChanged()
        })
    }
}
