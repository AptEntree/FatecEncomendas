package com.example.fatecencomendas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fatecencomendas.R
import com.example.fatecencomendas.databinding.FragmentHomeBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel.initRepositories(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()

        Firebase.auth.currentUser?.let { viewModel.getPackageFromUserUid(it.email) }

        binding.tvExitHome.setOnClickListener {
            Firebase.auth.signOut()
            findNavController().navigate(R.id.loginFragment)
        }
    }

    private fun setListeners() {
        viewModel.packageList.observe(viewLifecycleOwner) {
            with(binding) {
                if (it.isNullOrEmpty()) {
                    tvNoPackage.visibility = View.VISIBLE
                    rvPackages.visibility = View.GONE
                } else {
                    tvNoPackage.visibility = View.GONE
                    rvPackages.visibility = View.VISIBLE
                    rvPackages.adapter = HomeAdapter(it)
                }
            }
        }
    }
}