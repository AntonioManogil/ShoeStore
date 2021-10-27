package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.viewmodels.InstructionViewModel

class InstructionFragment : Fragment() {
    private lateinit var viewModel : InstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentInstructionBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_instruction, container, false)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)
        binding.lifecycleOwner = this
        binding.instructionViewModel = viewModel
        viewModel.eventGoToShoeList.observe(viewLifecycleOwner,{
            if(it){
                findNavController().navigate(InstructionFragmentDirections
                    .actionInstructionFragmentToShoeListFragment())
                viewModel.onGoToShoeListComplete()
            }
        })
        return binding.root
    }
}