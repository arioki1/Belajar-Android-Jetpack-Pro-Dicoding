package com.arioki.belajarandroidjetpackpro.ui.render.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.data.ModuleEntity
import com.arioki.belajarandroidjetpackpro.ui.render.CourseReaderActivity
import com.arioki.belajarandroidjetpackpro.ui.render.CourseReaderCallback
import com.arioki.belajarandroidjetpackpro.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_module_list.*

class ModuleListFragment : Fragment(),MyAdapterClickListener {
    companion object{
        val TAG = ModuleListFragment::class.java.simpleName
    }
    lateinit var adapter: ModuleListAdapter
    lateinit var courseReaderCallback: CourseReaderCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            adapter = ModuleListAdapter(this)
            populateRecyclerView(DataDummy.generateDummyModules("a14"));
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }
    private fun populateRecyclerView(modules: ArrayList<ModuleEntity>) {
        progress_bar.visibility = View.GONE
        adapter.setModules(modules)
        rv_module.layoutManager = LinearLayoutManager(context)
        rv_module.setHasFixedSize(true)
        rv_module.adapter = adapter
        val dividerItemDecoration =
            DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position,moduleId)
    }
}
