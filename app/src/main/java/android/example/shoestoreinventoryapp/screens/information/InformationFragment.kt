package android.example.shoestoreinventoryapp.screens.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.example.shoestoreinventoryapp.R
import android.example.shoestoreinventoryapp.databinding.FragmentInformationBinding
import android.example.shoestoreinventoryapp.databinding.FragmentWelcomeBinding
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class InformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_information, container, false)

        binding.btnGotIt.setOnClickListener {
            it.findNavController().navigate(R.id.action_informationFragment_to_shoeListFragment )
        }

        return binding.root
    }
}