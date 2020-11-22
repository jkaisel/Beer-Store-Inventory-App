package android.example.beerstoreinventoryapp.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentBeerListBinding
import android.example.beerstoreinventoryapp.BeerViewModel
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class BeerListFragment : Fragment() {

    private lateinit var binding: FragmentBeerListBinding
    private val viewModel: BeerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.beerList.observe(viewLifecycleOwner, Observer {newElement ->
            if(viewModel.beerList.value!!.size != 0) {
                val beerInfo =
                    StringBuilder().append(viewModel.beerList.value!!.get(viewModel.beerList.value!!.size - 1))
                val beerTextView = TextView(context)
                beerTextView.text = beerInfo.toString()
                binding.shoeListLayout.addView(beerTextView)
            }
        })

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