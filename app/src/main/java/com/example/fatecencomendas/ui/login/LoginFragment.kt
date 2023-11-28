package com.example.fatecencomendas.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fatecencomendas.R
import com.example.fatecencomendas.databinding.FragmentLoginBinding
import com.example.fatecencomendas.util.AppConstants

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        viewModel.initRepositories(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()

        with(binding) {
            btLogin.setOnClickListener {
                viewModel.tryLogin(
                    email = etEmailInput.text.toString(),
                    password = etPasswordInput.text.toString()
                )
            }
        }
    }

    private fun setListeners() {
        viewModel.loginInfo.observe(viewLifecycleOwner) {
            if (it == null) {
                Toast.makeText(requireContext(), "Falhou", Toast.LENGTH_LONG).show()
            } else {
                it.email?.let { email ->
                    if(!AppConstants.isAdmin(email)) findNavController().navigate(R.id.homeFragment)
                    else findNavController().navigate(R.id.addPackageFragment)
                }
            }
        }
    }

}