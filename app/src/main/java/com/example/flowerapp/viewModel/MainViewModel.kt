package com.example.flowerapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowerapp.api.ApiClient
import com.example.flowerapp.model.Items
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel :ViewModel() {

    var items: MutableLiveData<List<Items>>? = MutableLiveData()
    var featuredItems: MutableLiveData<List<Items>>? = MutableLiveData()

    init {
        getItems()
    }

   private fun getItems(){
       CoroutineScope(Dispatchers.IO).launch {
           val response =ApiClient.apiService.getItems()

           if(response.isSuccessful){
               withContext(Dispatchers.Main){
                   items?.value = response.body()?.result?.data
                   featuredItems?.value=response.body()?.result?.featured_items
                   println("")
               }
           }
       }
   }

}