package com.example.assignment_006

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_006.databinding.RealEstateFragmentBinding

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

        binding.btn.setOnClickListener {

            progressBarVisible()

            viewModel.startRealEstate()
            viewModel.dataFromRealEstate.observe(viewLifecycleOwner) {
                val list2 = mutableListOf(it)
                adapter.setData(list2)
            }
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