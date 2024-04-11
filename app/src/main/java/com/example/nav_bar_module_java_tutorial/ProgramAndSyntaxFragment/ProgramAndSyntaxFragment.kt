package com.example.nav_bar_module_java_tutorial.ProgramAndSyntaxFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_bar_module_java_tutorial.R
import com.example.nav_bar_module_java_tutorial.databinding.FragmentProgramAndSyntaxBinding


class ProgramAndSyntaxFragment : Fragment() {
    private val dataList: MutableList<DataModel> = mutableListOf()
    private val dataList2: MutableList<DataModel> = mutableListOf()
    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private var _binding: FragmentProgramAndSyntaxBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramAndSyntaxBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView")

        setCardLayoutButton()

        // Initialize RecyclerView
        itemRecyclerView = binding.mainRecyclervie
        Log.d(TAG, "RecyclerView initialized")

        // Initialize Adapter
       // itemAdapter = ItemAdapter(dataList, requireActivity().supportFragmentManager)
        itemAdapter = ItemAdapter(dataList)

        //itemAdapter = ItemAdapter(dataList)
        Log.d(TAG, "Adapter initialized")

        // Set LinearLayoutManager to RecyclerView
        itemRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set Adapter to RecyclerView
        itemRecyclerView.adapter = itemAdapter
        Log.d(TAG, "Adapter set to RecyclerView")

        // Populate data list
        populateDataList()
        populateDataList2()
        // Notify adapter of data change
        itemAdapter.notifyDataSetChanged()
        Log.d(TAG, "Data set changed")

        return binding.root
    }

    private fun setCardLayoutButton() {
        binding.cardLayout1.setOnClickListener {
            // Set card layout 1
            Log.d(TAG, "Card Layout 1 clicked")
            // Notify the adapter that the data set has changed
            binding.programText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            binding.syntaxText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            //binding.option1.background = ContextCompat.getDrawable(this, R.drawable.bgcard)

            binding.cardLayout1.setBackgroundResource(R.drawable.gredient_background_program)
            binding.cardLayout2.setBackgroundResource(R.drawable.bgcard)
            //itemAdapter = ItemAdapter(dataList)
            itemAdapter = ItemAdapter(dataList)
            Log.d(TAG, "Adapter initialized")
            dataList.clear()
            // Set LinearLayoutManager to RecyclerView
            itemRecyclerView.layoutManager = LinearLayoutManager(requireContext())

            // Set Adapter to RecyclerView
            itemRecyclerView.adapter = itemAdapter
            Log.d(TAG, "Adapter set to RecyclerView")

            // Populate data list
            populateDataList()

            // Notify adapter of data change
            itemAdapter.notifyDataSetChanged()
        }

        binding.cardLayout2.setOnClickListener {

            // Set card layout 2
            Log.d(TAG, "Card Layout 2 clicked")
            // Notify the adapter that the data set has changed
            dataList2.clear()
            binding.programText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            binding.syntaxText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            binding.cardLayout2.setBackgroundResource(R.drawable.gredient_background_program)
            binding.cardLayout1.setBackgroundResource(R.drawable.bgcard)

            //itemAdapter = ItemAdapter(dataList2)
            itemAdapter = ItemAdapter(dataList2)
            Log.d(TAG, "Adapter initialized")

            // Set LinearLayoutManager to RecyclerView
            itemRecyclerView.layoutManager = LinearLayoutManager(requireContext())

            // Set Adapter to RecyclerView
            itemRecyclerView.adapter = itemAdapter
            Log.d(TAG, "Adapter set to RecyclerView")

            // Populate data list
            populateDataList2()

            // Notify adapter of data change
            itemAdapter.notifyDataSetChanged()
        }
    }

    private fun populateDataList() {
        // Add some sample data to your data list (dataList)
        val nestedList1 = listOf(
            "key1" to "1value1",
            "key2" to "1value2"
        )



        val nestedList2 = listOf(
            "key3" to "kotlinCodeBuilder",
            "key4" to "1value4"
        )

        // Add DataModel instances to your dataList
        dataList.add(DataModel(nestedList1, "Example Text 1"))
        dataList.add(DataModel(nestedList2, "Example Text 2"))
        // Add more DataModel instances as needed
    }
    private fun populateDataList2() {
        // Add some sample data to your data list (dataList)
        val nestedList11 = listOf(
            "22key1" to getString(R.string.hello_world_program).toString(),
            "2key2" to "2value2"
        )
        val nestedList22 = listOf(
            "2key3" to "2value3",
            "2key4" to "2value4"
        )

        // Add DataModel instances to your dataList
        dataList2.add(DataModel(nestedList11, "2Example Text 1"))
        dataList2.add(DataModel(nestedList22, "2Example Text 2"))
        // Add more DataModel instances as needed
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "ProgramAndSyntaxFragment"
    }
}

