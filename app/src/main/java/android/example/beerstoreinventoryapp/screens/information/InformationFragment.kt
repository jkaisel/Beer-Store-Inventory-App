package android.example.beerstoreinventoryapp.screens.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentInformationBinding
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

class InformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_information, container, false)

        binding.btnGotIt.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_informationFragment_to_beerListFragment )
        }

        return binding.root
    }
}