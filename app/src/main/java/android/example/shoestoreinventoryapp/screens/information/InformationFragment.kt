package android.example.shoestoreinventoryapp.screens.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.shoestoreinventoryapp.R
import android.example.shoestoreinventoryapp.databinding.FragmentInformationBinding
import android.example.shoestoreinventoryapp.databinding.FragmentWelcomeBinding
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
            it.findNavController().navigate(R.id.action_informationFragment_to_shoeListFragment )
        }


        return binding.root
    }
}