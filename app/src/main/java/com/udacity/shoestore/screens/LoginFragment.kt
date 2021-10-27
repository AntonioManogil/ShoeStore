package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this
        binding.loginViewModel = viewModel

        viewModel.eventGoToWelcome.observe(viewLifecycleOwner, {
            if (it) {
                if (binding.etEmailSignIn.text.toString() != "" &&
                    binding.etPasswordSignIn.text.toString() != ""
                ) {
                    viewModel.setEmail(binding.etEmailSignIn.text.toString())
                    viewModel.setPassword(binding.etPasswordSignIn.toString())
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                } else {
                    Toast.makeText(
                        activity, "You should provide email and password!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                viewModel.onGoToWelcomeComplete()
            }
        })
        return binding.root
    }
}