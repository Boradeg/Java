package com.example.nav_bar_module_java_tutorial.QuestionsFragment

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
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_bar_module_java_tutorial.R
import com.example.nav_bar_module_java_tutorial.databinding.FragmentQuestionsBinding
import java.util.Locale


class QuestionsFragment : Fragment() {

    private var mList = ArrayList<QueData>()
    private lateinit var adapter: LanguageAdapter
    private lateinit var db: NotesDBHelper
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = NotesDBHelper(requireContext())

        binding.cardLayout1.setOnClickListener {
            binding.interviewQueText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            binding.codingQueText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            binding.cardLayout1.setBackgroundResource(R.drawable.gredient_background_program)
            binding.cardLayout2.setBackgroundResource(R.drawable.bgcard)
        }

        binding.cardLayout2.setOnClickListener {
            binding.interviewQueText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            binding.codingQueText.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
            binding.cardLayout2.setBackgroundResource(R.drawable.gredient_background_program)
            binding.cardLayout1.setBackgroundResource(R.drawable.bgcard)
        }

        // Hide ActionBar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = LanguageAdapter(mList, requireContext())
        binding.recyclerView.adapter = adapter

        addAllNotesManually()
        loadNotes()
    }

    private fun addAllNotesManually() {
        val notesList = mutableListOf(
            QueData(0, "Why is multiple inheritance not supported in Java?", "Java does not support multiple inheritance because it can lead to complexities and ambiguities, such as the diamond problem."),
            QueData(0, "What is Kotlin?", "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference."),
            // Add more notes here as needed
        )

        for (note in notesList) {
            db.insertNote(note.question, note.answer)
        }
    }

    private fun loadNotes() {
        val notes = db.getAllNotes()
        adapter.updateNotes(notes)
    }
}

class LanguageAdapter(private var mList: List<QueData>, val context: Context) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
        val langDescTv: TextView = itemView.findViewById(R.id.langDesc)
        val constraintLayout: RelativeLayout = itemView.findViewById(R.id.constraintLayout)

        fun collapseExpandedView() {
            langDescTv.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.each_item_interview_que, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val languageData = mList[position]

        holder.titleTv.text = languageData.question
        holder.langDescTv.text = languageData.answer

        val isExpandable: Boolean = languageData.isExpandable
        holder.langDescTv.visibility = if (isExpandable) View.VISIBLE else View.GONE

        setAnimation(holder.itemView, position)

        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            languageData.isExpandable = !languageData.isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = mList.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position) {
            mList[temp].isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: LanguageViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 0) {
            holder.collapseExpandedView()
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }



    fun updateNotes(notes: List<QueData>) {
        mList = notes
        notifyDataSetChanged()
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        val slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
        viewToAnimate.startAnimation(slideIn)
    }
}