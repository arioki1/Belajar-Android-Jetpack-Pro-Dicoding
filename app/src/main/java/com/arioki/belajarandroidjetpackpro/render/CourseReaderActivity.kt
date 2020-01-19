package com.arioki.belajarandroidjetpackpro.render

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.render.content.ModuleContentFragment
import com.arioki.belajarandroidjetpackpro.render.list.ModuleListFragment


class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {
    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)
        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null) {
                populateFragment()
            }
        }
    }

    private fun populateFragment() {
        val fragmentTransaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        val fragment = ModuleListFragment()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun moveTo(position: Int, moduleId: String) {
        val fragment: Fragment = ModuleContentFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}
