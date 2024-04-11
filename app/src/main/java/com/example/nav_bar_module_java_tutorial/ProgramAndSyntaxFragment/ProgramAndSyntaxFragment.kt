package com.example.nav_bar_module_java_tutorial.ProgramAndSyntaxFragment

import android.os.Bundle
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

    private var recyclerView: RecyclerView? = null
    private var mList: List<DataModel>? = null
    private var mList3: List<DataModel3>? = null
    private var adapter: ItemAdapter? = null
    private var _binding: FragmentProgramAndSyntaxBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramAndSyntaxBinding.inflate(inflater, container, false)


        binding.cardLayout1.setOnClickListener {
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
            binding.cardLayout1.setBackgroundResource(R.drawable.gredient_background_program)
            binding.cardLayout2.setBackgroundResource(R.drawable.bgcard)
        }

        binding.cardLayout2.setOnClickListener {
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
        }




        binding.mainRecyclervie.setHasFixedSize(true)
        binding.mainRecyclervie.setLayoutManager(LinearLayoutManager(requireContext()))


        mList = ArrayList<DataModel>()
        mList3 = ArrayList<DataModel3>()

        val nestedList1: MutableList<String> = ArrayList()
        nestedList1.add("Pune-Satara Road Widening")
//        nestedList1.add("Nipani-Chikodi Road Widening")
//        nestedList1.add("Daund - Bhigwan Line Survey")
//        nestedList1.add("Chyawanprash and Health Foods")

//
//        val nestedList2: MutableList<String> = ArrayList()
//        nestedList2.add("Book")
//        nestedList2.add("Pen")
//        nestedList2.add("Office Chair")
//        nestedList2.add("Pencil")
//        nestedList2.add("Eraser")
//        nestedList2.add("NoteBook")
//        nestedList2.add("Map")
//        nestedList2.add("Office Table")
//
//        val nestedList3: MutableList<String> = ArrayList()
//        nestedList3.add("Decorates")
//        nestedList3.add("Tea Table")
//        nestedList3.add("Wall Paint")
//        nestedList3.add("Furniture")
//        nestedList3.add("Bedsits")
//        nestedList3.add("Certain")
//        nestedList3.add("Namkeen and Snacks")
//        nestedList3.add("Honey and Spreads")


//        items.add("Drone Survey")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
//        items.add("MMRDA Daund")
        val items: MutableList<String> = ArrayList()
        items.add("Introduction")
        (mList as ArrayList<DataModel>).add(DataModel(nestedList1, "Introduction"))
        (mList3 as ArrayList<DataModel3>).add(DataModel3(Data1("subhead","content"),"basic"))

//        (mList as ArrayList<DataModel>).add(DataModel(nestedList2, items[1]))
//        (mList as ArrayList<DataModel>).add(DataModel(nestedList3, items[2]))
//        (mList as ArrayList<DataModel>).add(DataModel(nestedList3, items[3]))
//        (mList as ArrayList<DataModel>).add(DataModel(nestedList3, items[4]))
//        (mList as ArrayList<DataModel>).add(DataModel(nestedList3, items[5]))
//


        adapter = ItemAdapter(mList as ArrayList<DataModel>)
        binding.mainRecyclervie.setAdapter(adapter)




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
