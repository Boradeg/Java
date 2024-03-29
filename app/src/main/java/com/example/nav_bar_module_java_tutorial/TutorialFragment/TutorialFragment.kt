package com.example.nav_bar_module_java_tutorial.TutorialFragment

import ItemAdapterTutorial
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_bar_module_java_tutorial.databinding.FragmentTutorialBinding

class TutorialFragment : Fragment() {

    private var mList: List<DataModalTutorial>? = null
    private var adapter: ItemAdapterTutorial? = null

    private var _binding: FragmentTutorialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTutorialBinding.inflate(inflater, container, false)




        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.setLayoutManager(LinearLayoutManager(requireContext()))
        setDrawable()


        mList = ArrayList<DataModalTutorial>()

        //list1

        //list1
        val nestedList1: MutableList<String> = ArrayList()
        nestedList1.add("Pune-Satara Road Widening")
        nestedList1.add("Nipani-Chikodi Road Widening")
        nestedList1.add("Daund - Bhigwan Line Survey")
        nestedList1.add("Chyawanprash and Health Foods")


        val nestedList2: MutableList<String> = ArrayList()
        nestedList2.add("Book")
        nestedList2.add("Pen")
        nestedList2.add("Office Chair")
        nestedList2.add("Pencil")
        nestedList2.add("Eraser")
        nestedList2.add("NoteBook")
        nestedList2.add("Map")
        nestedList2.add("Office Table")

        val nestedList3: MutableList<String> = ArrayList()
        nestedList3.add("Decorates")
        nestedList3.add("Tea Table")
        nestedList3.add("Wall Paint")
        nestedList3.add("Furniture")
        nestedList3.add("Bedsits")
        nestedList3.add("Tea Table")
        nestedList3.add("Wall Paint")
        nestedList3.add("Furniture")
        nestedList3.add("Bedsits")
        nestedList3.add("Certain")
        nestedList3.add("Namkeen and Snacks")
        nestedList3.add("Certain")
        nestedList3.add("Namkeen and Snacks")
        nestedList3.add("Honey and Spreads")

        val items: MutableList<String> = ArrayList()
        items.add("Introduction")
        items.add("Drone Survey")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")
        items.add("MMRDA Daund")

        (mList as ArrayList<DataModalTutorial>).add(DataModalTutorial(nestedList1, items[0]))
        (mList as ArrayList<DataModalTutorial>).add(DataModalTutorial(nestedList2, items[1]))
        (mList as ArrayList<DataModalTutorial>).add(DataModalTutorial(nestedList3, items[2]))
        (mList as ArrayList<DataModalTutorial>).add(DataModalTutorial(nestedList3, items[3]))
        (mList as ArrayList<DataModalTutorial>).add(DataModalTutorial(nestedList3, items[4]))
        (mList as ArrayList<DataModalTutorial>).add(DataModalTutorial(nestedList3, items[5]))



        adapter = ItemAdapterTutorial(mList as ArrayList<DataModalTutorial>)
        binding.recyclerView.setAdapter(adapter)



        return binding.root
    }

    private fun setDrawable() {


    }


}