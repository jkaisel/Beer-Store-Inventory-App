package android.example.beerstoreinventoryapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentBeerDetailBinding
import android.example.beerstoreinventoryapp.models.Beer
import android.example.beerstoreinventoryapp.BeerViewModel
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import timber.log.Timber

class BeerDetailFragment : Fragment() {

    private lateinit var binding : FragmentBeerDetailBinding
    private val viewModel: BeerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.eventNavigateToList.observe(viewLifecycleOwner, { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_beerDetailFragment_to_beerListFragment)
                viewModel.onNavigateComplete()
            }
        })

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beer_detail, container, false)
        binding.beerViewModel = viewModel
        binding.btnCancel.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_beerDetailFragment_to_beerListFragment)
        }

        return binding.root
    }
}