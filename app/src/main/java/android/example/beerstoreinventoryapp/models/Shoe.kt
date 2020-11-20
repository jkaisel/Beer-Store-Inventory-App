package android.example.beerstoreinventoryapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var abv: Double, var type: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable