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
import retrofit2.HttpException
import java.io.IOException

class RealEstateModel : ViewModel() {

    private var _dataFromRealEstate = MutableLiveData<List<RS.Content>>()
    val dataFromRealEstate: LiveData<List<RS.Content>> get() = _dataFromRealEstate

    fun startRealEstate() {

        CoroutineScope(IO).launch {

            val response = try{
                RetrofitInstance.api.getRealEstate()
            }catch (e:IOException){
                e.message
                //Log.e("RS", "IOException")
                return@launch
            }catch (e:HttpException){
                e.message()
                //Log.e("RS", "HttpException")
                return@launch
            }
            if (response.isSuccessful && response.body() !=null){
                val list5 = response.body()!!.content
                _dataFromRealEstate.postValue(list5)
            }else{
                Log.e("RS", "no success")
            }






        }


    }


}