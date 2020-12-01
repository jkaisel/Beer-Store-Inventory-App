package android.example.beerstoreinventoryapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.beerstoreinventoryapp.R
import android.example.beerstoreinventoryapp.databinding.FragmentLoginBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnRegister.setOnClickListener {
                requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.btnLogin.setOnClickListener {
                requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }
}