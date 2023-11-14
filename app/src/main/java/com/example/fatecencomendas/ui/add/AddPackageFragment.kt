package com.example.fatecencomendas.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fatecencomendas.R
import com.example.fatecencomendas.databinding.FragmentAddPackageBinding
import com.example.fatecencomendas.util.AppConstants

class AddPackageFragment : Fragment() {

    private val viewModel: AddPackageViewModel by viewModels()

    private lateinit var binding: FragmentAddPackageBinding

    private var positionSelected = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPackageBinding.inflate(layoutInflater)
        viewModel.initRepositories(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()

        viewModel.getUserList()

        binding.tvExitAdd.setOnClickListener { findNavController().navigate(R.id.loginFragment) }
    }

    private fun setListeners() {
        viewModel.userList.observe(viewLifecycleOwner) {
            with(binding) {
                spUsers.adapter = ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    it.map { it.name })
                spUsers.onItemSelectedListener = ItemSelectListener()

                btAddPackage.setOnClickListener { _ ->
                    viewModel.addNewPackage(
                        arguments?.getInt(AppConstants.LOGIN_ID_PARAMETER)!!,
                        it[positionSelected].uid
                    )
                }
            }
        }

        viewModel.wasAdded.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Package added", Toast.LENGTH_LONG).show()
        }
    }

    inner class ItemSelectListener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            positionSelected = position
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            positionSelected = 0
        }
    }

}