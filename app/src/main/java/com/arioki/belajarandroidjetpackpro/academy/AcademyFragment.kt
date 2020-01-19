package com.arioki.belajarandroidjetpackpro.academy


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.belajarandroidjetpackpro.AcademyAdapter
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_academy.*


/**
 * A simple [Fragment] subclass.
 */
class AcademyFragment : Fragment() {
    lateinit var academyAdapter: AcademyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_academy, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            academyAdapter = AcademyAdapter(activity!!)
            academyAdapter.setListCourses(DataDummy.generateDummyCourses())

            rv_academy.layoutManager = LinearLayoutManager(activity)
            rv_academy.setHasFixedSize(true)
            rv_academy.adapter = academyAdapter

        }
    }

}
