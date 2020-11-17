package android.example.shoestoreinventoryapp.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.shoestoreinventoryapp.R
import android.example.shoestoreinventoryapp.databinding.FragmentLoginBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.eventEmptyFiled.observe(viewLifecycleOwner, Observer { isEmpty ->
            if(isEmpty){
                showNotification(1)
            }
        })

        viewModel.eventNotAnEmail.observe(viewLifecycleOwner, Observer {notEmail ->
            if(notEmail){
                showNotification(2)
            }
        })

        viewModel.eventUserAlreadyExists.observe(viewLifecycleOwner, Observer { userExists ->
            if(userExists){
                showNotification(3)
            }
        })

        viewModel.eventIncorrectPassword.observe(viewLifecycleOwner, Observer { isIncorrect ->
            if(isIncorrect){
                showNotification(4)
            }
        })

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            binding.tvLoginInfo.visibility = View.INVISIBLE
            viewModel.resetEvents()

            if(viewModel.checkFields(email, password) && viewModel.checkIfUserDoesntExist(email)){
                viewModel.addNewUser(email, password)
                //TODO Navigate
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(viewModel.checkPassword(email, password)){
                //TODO Navigate
            }
        }

        return binding.root
    }


    fun showNotification(variant: Int){
        val info: String
        when(variant){
            1 -> info = "Fields email and password cannot be empty"
            2 -> info = "Please enter a valid email"
            3 -> info = "Fields email and password cannot be empty"
            else -> info = "Incorrect password or email"
        }
        binding.tvLoginInfo.text = info
        binding.tvLoginInfo.visibility = View.VISIBLE
    }
}