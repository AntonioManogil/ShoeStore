package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.LayoutShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ActivityViewModel
import com.udacity.shoestore.viewmodels.ShoeListViewModel

class ShoeListFragment : Fragment() {
    private lateinit var viewModel : ShoeListViewModel
    private lateinit var binding: FragmentShoeListBinding
    private val viewModelActivity : ActivityViewModel by activityViewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.logout -> {
                //val navOption = NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                viewModelActivity.Clear()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_shoe_list, container, false)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.lifecycleOwner = this
        binding.shoeListViewModel = viewModel

        viewModel.eventGoToShoeDetail.observe(viewLifecycleOwner,{
            if(it){
                findNavController().navigate(ShoeListFragmentDirections
                    .actionShoeListFragmentToShoeDetailFragment())
                viewModel.onGoToShoeDetailComplete()
            }
        })
        // The Detail screen needs to add the new item to the view model.
        // The listing screen should be listening to that model and show the new item.
        viewModelActivity.shoeList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                for(shoe: Shoe in it) {
                    val itemBinding: LayoutShoeItemBinding = DataBindingUtil.inflate(
                        LayoutInflater.from(requireContext()),
                        R.layout.layout_shoe_item, container, false
                    )
                    itemBinding.shoe = shoe
                    binding.llShoeList.addView(itemBinding.root)
                }
            }
        })
        return binding.root
    }
}