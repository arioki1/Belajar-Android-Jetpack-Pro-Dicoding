package com.arioki.belajarandroidjetpackpro.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.ui.render.CourseReaderActivity
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.generateDummyModules
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.getCourse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.content_detail_course.*


class DetailCourseActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE = "extra_course"
        lateinit var adapter: DetailCourseAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        adapter = DetailCourseAdapter()

        rv_module.isNestedScrollingEnabled = false
        rv_module.layoutManager = LinearLayoutManager(this)
        rv_module.setHasFixedSize(true)
        rv_module.adapter = adapter
        val dividerItemDecoration =
            DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)

        intent.extras?.let {
            val courseId = it.getString(EXTRA_COURSE)
            if (courseId != null) {
                adapter.setModules(generateDummyModules(courseId))
                populateCourse(courseId)
            }
        }

    }

    private fun populateCourse(courseId: String) {
        val courseEntity = getCourse(courseId)
        courseEntity?.let { it ->
            text_title.text = it.title
            text_description.text = it.description
            text_date.text = String.format("Deadline %s", it.deadline)
            Glide.with(applicationContext)
                .load(it.imagePath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(image_poster)
            btn_start.setOnClickListener {
                val intent =
                    Intent(this, CourseReaderActivity::class.java)
                intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseId)
                it.context.startActivity(intent)
            }
        }
    }

}
