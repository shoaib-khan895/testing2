package com.example.mokito

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class ItemModel(private val context: Context) {
    private val FAVORITEKEY = "isFavorite"
    // Getting shared preferences reference
    private val preferences: SharedPreferences = context.getSharedPreferences("favorite", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun saveFavoriteItems(favoriteItem: ItemDataClass) {
        editor.putBoolean(FAVORITEKEY, favoriteItem.isFavorite)
        editor.commit()
        Toast.makeText(context, "Item added to Favorite", Toast.LENGTH_SHORT).show()
    }

    fun getFavoriteItems(): MutableLiveData<Boolean> {
        return MutableLiveData(preferences.getBoolean(FAVORITEKEY, false))
    }

    fun removeFavoriteItems() {
        editor.remove(FAVORITEKEY)
        editor.commit()
        Toast.makeText(context, "Item removed from Favorite", Toast.LENGTH_SHORT).show()
    }
}