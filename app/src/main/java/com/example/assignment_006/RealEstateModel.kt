package com.example.assignment_006

import RetrofitInstance
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment_006.model.RS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RealEstateModel : ViewModel() {

    private var _dataFromRealEstate = MutableLiveData<RS.Content>()
    val dataFromRealEstate: LiveData<RS.Content> get() = _dataFromRealEstate

    fun startRealEstate() {
        CoroutineScope(IO).launch {
            val response = RetrofitInstance.api.getRealEstate()
            if (response.isSuccessful && response.body() != null) {
                _dataFromRealEstate.postValue(response.body()!!)
            } else {
                Log.e("RS", "no success")
            }
        }


    }


}