package android.example.beerstoreinventoryapp.viewmodels

import android.example.beerstoreinventoryapp.models.Beer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeerViewModel: ViewModel() {

    private val _beerList = MutableLiveData<MutableList<Beer>>()
    val beerList: LiveData<MutableList<Beer>>
        get() = _beerList

    private val _beer = MutableLiveData<Beer>()
    val beer : LiveData<Beer>
        get() = _beer

    private val _eventNavigateToList = MutableLiveData<Boolean>()
    val eventNavigateToList: LiveData<Boolean>
        get() = _eventNavigateToList

    private val _eventEmptyField = MutableLiveData<Boolean>()
    val eventEmptyField: LiveData<Boolean>
        get() = _eventEmptyField

    init {
        _eventEmptyField.value = false
        _beerList.value = mutableListOf()
        _beer.value = Beer("","","","")
    }

    fun addBeerToList() {
        if(checkFields(beer.value!!.name, beer.value!!.type, beer.value!!.abv, beer.value!!.description)) {
            _beerList.value!!.add(beer.value!!)
            _eventNavigateToList.value = true
            resetShoeForm()
            _eventEmptyField.value = false
        }
    }

    fun onNavigateComplete(){
        _eventNavigateToList.value = false
    }

    fun resetShoeForm() {
        _beer.value = Beer("","","","")
    }

    fun checkFields(name: String, type: String, abv: String, description: String): Boolean{
        if(name.isEmpty() || type.isEmpty() || abv.isEmpty() || description.isEmpty()){
            _eventEmptyField.value = true
            return false
        }
        return true
    }
}