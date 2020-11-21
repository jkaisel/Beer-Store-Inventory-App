package android.example.beerstoreinventoryapp.screens.list

import android.example.beerstoreinventoryapp.models.Beer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeerListViewModel: ViewModel() {

    private val _beerList = MutableLiveData<MutableList<Beer>>()
    val shoeList: LiveData<MutableList<Beer>>
        get() = _beerList
}