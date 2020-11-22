package android.example.beerstoreinventoryapp

import android.example.beerstoreinventoryapp.models.Beer
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class BeerViewModel: ViewModel() {

    private val _beerList = MutableLiveData<MutableList<Beer>>()
    val beerList: LiveData<MutableList<Beer>>
        get() = _beerList

    val _beer = MutableLiveData<Beer>()
    val beer : LiveData<Beer>
        get() = _beer

    init {
        _beerList.value = mutableListOf()
        _beer.value = Beer("",0.0,"","")
    }

    fun addBeerToList() {
        _beerList.value!!.add(beer.value!!)
        Timber.i(_beer.value!!.name)
    }
}