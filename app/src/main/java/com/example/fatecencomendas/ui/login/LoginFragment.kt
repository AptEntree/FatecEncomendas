package com.example.fatecencomendas.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            if (it != -1) findNavController().navigate(
                R.id.homeFragment,
                Bundle().apply { putInt(AppConstants.LOGIN_ID_PARAMETER, it) })
            else Toast.makeText(requireContext(), "Falhou $it", Toast.LENGTH_LONG).show()
        }
    }

}