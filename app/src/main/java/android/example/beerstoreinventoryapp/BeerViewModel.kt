package android.example.beerstoreinventoryapp

import android.example.beerstoreinventoryapp.models.Beer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeerViewModel: ViewModel() {

    private val _beerList = MutableLiveData<MutableList<Beer>>()
    val beerList: LiveData<MutableList<Beer>>
        get() = _beerList

    init {
        _beerList.value = mutableListOf()
    }

    fun addBeerToList(beer: Beer) {
        _beerList.value?.add(beer)
    }
}