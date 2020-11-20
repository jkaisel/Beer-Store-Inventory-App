package android.example.beerstoreinventoryapp.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentWelcomeBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)

        binding.btnNext.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_welcomeFragment_to_informationFragment)
        }

        return binding.root
    }
}