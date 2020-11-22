package android.example.beerstoreinventoryapp.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentBeerListBinding
import android.example.beerstoreinventoryapp.BeerViewModel
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class BeerListFragment : Fragment() {

    private lateinit var binding: FragmentBeerListBinding
    private val viewModel: BeerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beer_list, container, false)
        setHasOptionsMenu(true)

        binding.fab.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_beerListFragment_to_beerDetailFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}