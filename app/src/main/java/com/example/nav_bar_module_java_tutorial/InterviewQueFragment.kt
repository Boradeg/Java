package com.example.nav_bar_module_java_tutorial

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_bar_module_java_tutorial.databinding.FragmentInterviewQueBinding
import java.util.Locale

class InterviewQueFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter
    private var param2: String? = null
    private var _binding:FragmentInterviewQueBinding? = null
    private val binding get() = _binding!!
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment using View Binding
            _binding = FragmentInterviewQueBinding.inflate(inflater, container, false)
            return binding.root
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hide ActionBar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()


        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        addDataToList()
        adapter = LanguageAdapter(mList,requireContext())
        binding.recyclerView.adapter = adapter


    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "The HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "C++ is a high-level general-purpose programming language created by Danish computer scientist Bjarne Stroustrup as an extension of the C programming language, or C with Classes."

            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries."
            )
        )
        mList.add(
            LanguageData(
                "Why is multiple inheritance not supported in java ?",

                "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            )
        )
    }

}
data class LanguageData(
    val title: String,

    val desc: String,
    var isExpandable: Boolean = false
)

class LanguageAdapter(private var mList: List<LanguageData>,val context: Context) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
        val langDescTv: TextView = itemView.findViewById(R.id.langDesc)
        val constraintLayout: RelativeLayout = itemView.findViewById(R.id.constraintLayout)




        fun collapseExpandedView(){
            langDescTv.visibility = View.GONE
        }
    }

    fun setFilteredList(mList: List<LanguageData>) {
        this.mList = mList
        notifyDataSetChanged()
    }
    private fun setAnimation(viewToAnimate: View, position: Int) {
        val slide_in = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
        viewToAnimate.startAnimation(slide_in)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item_interview_que, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {

        val languageData = mList[position]

        holder.titleTv.text = languageData.title
        holder.langDescTv.text = languageData.desc

        val isExpandable: Boolean = languageData.isExpandable
        holder.langDescTv.visibility = if (isExpandable) View.VISIBLE else View.GONE

        setAnimation(holder.itemView,position)

        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            languageData.isExpandable = !languageData.isExpandable
            notifyItemChanged(position , Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int){
        val temp = mList.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position){
            mList[temp].isExpandable = false
            notifyItemChanged(temp , 0)
        }
    }

    override fun onBindViewHolder(
        holder: LanguageViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {

        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
