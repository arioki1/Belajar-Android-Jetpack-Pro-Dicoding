package com.arioki.belajarandroidjetpackpro.ui.academy


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import kotlinx.android.synthetic.main.fragment_academy.*


/**
 * A simple [Fragment] subclass.
 */
class AcademyFragment : Fragment() {
    companion object {
        fun newInstance(): AcademyFragment {
            return AcademyFragment()
        }
    }

    private lateinit var viewModel: AcademyViewModel
    private lateinit var courses: List<CourseEntity>

    private lateinit var academyAdapter: AcademyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_academy, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(this).get(AcademyViewModel::class.java)
            courses = viewModel.getCourses()
            academyAdapter = AcademyAdapter(it)
            academyAdapter.setListCourses(courses)
            rv_academy.layoutManager = LinearLayoutManager(it)
            rv_academy.setHasFixedSize(true)
            rv_academy.adapter = academyAdapter
        }
    }
}