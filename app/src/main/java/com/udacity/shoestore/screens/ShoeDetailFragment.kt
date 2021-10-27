package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ActivityViewModel
import com.udacity.shoestore.viewmodels.ShoeDetailViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel : ShoeDetailViewModel
    private val viewModelActivity : ActivityViewModel by activityViewModels()
    private lateinit var shoe : Shoe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        shoe = Shoe("",0.0,"","")
        binding.lifecycleOwner = this
        binding.shoeDetailViewModel = viewModel
        binding.shoe = shoe

        viewModel.eventSaveShoe.observe(viewLifecycleOwner,{
            if(it) {
                if (binding.etCompany.text.toString() != "" &&
                    binding.etShoeDescription.text.toString() != "" &&
                    binding.etShoeName.text.toString() != ""
                ) {
                    val navOption = NavOptions.Builder().setPopUpTo(R.id.shoeListFragment,
                        false).build()
                    // navController.navigate(R.id.loginFragment, null, navOption)

                    findNavController().navigate(ShoeDetailFragmentDirections
                        .actionShoeDetailFragmentToShoeListFragment(), navOption)
                    viewModelActivity.AddItem(shoe)
                    viewModel.onSaveShoeComplete()
                } else {
                    Toast.makeText(
                        activity, "You should provide shoe details!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })

        viewModel.eventCancelShoe.observe(viewLifecycleOwner,{
            if(it) {
                findNavController().navigate(
                    ShoeDetailFragmentDirections
                        .actionShoeDetailFragmentToShoeListFragment()
                )
                viewModel.onCancelShoeComplete()
            }
        })
        return binding.root
    }
}