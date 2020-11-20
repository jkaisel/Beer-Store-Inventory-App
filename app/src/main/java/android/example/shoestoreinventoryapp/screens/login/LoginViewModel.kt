package android.example.shoestoreinventoryapp.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val userList = mutableMapOf<String, String>()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _eventEmptyField = MutableLiveData<Boolean>()
    val eventEmptyFiled: LiveData<Boolean>
        get() = _eventEmptyField

    private val _eventNotAnEmail = MutableLiveData<Boolean>()
    val eventNotAnEmail: LiveData<Boolean>
        get() = _eventNotAnEmail

    private val _eventUserAlreadyExists = MutableLiveData<Boolean>()
    val eventUserAlreadyExists : LiveData<Boolean>
        get() = _eventUserAlreadyExists

    private val _eventIncorrectPassword = MutableLiveData<Boolean>()
    val eventIncorrectPassword: LiveData<Boolean>
        get() = _eventIncorrectPassword



    init {
        _eventEmptyField.value = false
        _eventNotAnEmail.value = false
        _eventUserAlreadyExists.value = false
        _eventIncorrectPassword.value = false
    }


    fun checkFields(email: String, password: String): Boolean{
        if(email.isEmpty() || password.isEmpty()) {
            _eventEmptyField.value = true
            return false
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _eventNotAnEmail.value = true
            return false
        }

        return true
    }

    fun checkIfUserDoesntExist(email: String): Boolean{
        if(userList.containsKey(email)){
            _eventUserAlreadyExists.value = true
            return false
        }
        return true
    }

    fun addNewUser(email: String, password: String){
        userList.put(email, password)
    }

    fun resetEvents(){
        _eventEmptyField.value = false
        _eventNotAnEmail.value = false
        _eventUserAlreadyExists.value = false
    }

    fun checkPassword(email: String, password: String): Boolean {
        //TODO: Handle not existing user
        if(userList.getValue(email) != password || !userList.containsKey(email)){
            _eventIncorrectPassword.value = true
            return false
        }

        return true
    }
}