package com.example.mokito

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.*

class ItemViewModel(application: Application): AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext
    private val itemRepository: ItemRepository = ItemRepository(context)
    val isItemFavorite: MutableLiveData<Boolean> = itemRepository.getFavoriteItem()
    private val TAG = ItemViewModel::class.java.simpleName

    fun removeFromFavorite(){
        itemRepository.removeFavoriteItem()
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Remove Fav ${itemRepository.getFavoriteItem().value}")
    }

    fun saveInFavorite(favoriteItem: ItemDataClass) {
        itemRepository.saveFavoriteItem(favoriteItem)
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Save Fav ${itemRepository.getFavoriteItem().value}")
    }
}