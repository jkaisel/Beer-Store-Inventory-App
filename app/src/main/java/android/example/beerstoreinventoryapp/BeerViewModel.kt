package android.example.beerstoreinventoryapp

import android.example.beerstoreinventoryapp.models.Beer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

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

    init {
        _beerList.value = mutableListOf()
        _beer.value = Beer("","","","")
    }

    fun addBeerToList() {
        _beerList.value!!.add(beer.value!!)
        _eventNavigateToList.value = true
    }

    fun onNavigateComplete(){
        _eventNavigateToList.value = false
    }

//    fun resetShoeForm() {
//        _
//    }
}