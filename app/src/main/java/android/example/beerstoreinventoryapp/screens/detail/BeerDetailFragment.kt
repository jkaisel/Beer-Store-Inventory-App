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
import timber.log.Timber

class BeerDetailFragment : Fragment() {

    private lateinit var binding : FragmentBeerDetailBinding
    private val viewModel: BeerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beer_detail, container, false)

        binding.btnCancel.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_beerDetailFragment_to_beerListFragment)
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val abv = binding.etAbv.text.toString().toDouble()
            val type = binding.etType.text.toString()
            val description = binding.etDescription.text.toString()

            viewModel.addBeerToList(Beer(name, abv, type, description))
            requireView().findNavController().navigate(R.id.action_beerDetailFragment_to_beerListFragment)
        }

        return binding.root
    }
}