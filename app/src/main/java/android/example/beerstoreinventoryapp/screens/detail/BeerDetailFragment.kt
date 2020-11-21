package android.example.beerstoreinventoryapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentBeerDetailBinding
import androidx.databinding.DataBindingUtil

class BeerDetailFragment : Fragment() {

    private lateinit var binding : FragmentBeerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beer_detail, container, false)
        return binding.root
    }
}