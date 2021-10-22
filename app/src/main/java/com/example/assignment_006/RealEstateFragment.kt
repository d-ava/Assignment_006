package com.example.assignment_006

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_006.databinding.RealEstateFragmentBinding
import com.example.assignment_006.model.RS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class RealEstateFragment :
    BaseFragment<RealEstateFragmentBinding, RealEstateModel>(RealEstateFragmentBinding::inflate) {

    override var useSharedViewModel = false

    override fun getViewModel(): Class<RealEstateModel> = RealEstateModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RealEstateAdapter()
        val layoutManager = LinearLayoutManager(context)
        binding.RV.adapter = adapter
        binding.RV.layoutManager = layoutManager


        progressBarVisible()

        viewModel.startRealEstate()
        viewModel.dataFromRealEstate.observe(viewLifecycleOwner) {

            adapter.setData(it)
            progressBarInvisible()
        }


        


    }

    private fun progressBarVisible() {
        binding.progressIn.visibility = View.VISIBLE
        binding.progressOut.visibility = View.VISIBLE
    }

    private fun progressBarInvisible() {
        binding.progressIn.visibility = View.INVISIBLE
        binding.progressOut.visibility = View.INVISIBLE
    }


}