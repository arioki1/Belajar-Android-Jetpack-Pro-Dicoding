package com.arioki.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import com.arioki.belajarandroidjetpackpro.data.ModuleEntity
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.generateDummyCourses
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.generateDummyModules


class DetailCourseViewModel : ViewModel() {
    private lateinit var mCourse: CourseEntity
    private lateinit var courseId: String

    fun getCourse(): CourseEntity {
        for (i in generateDummyCourses().indices) {
            val courseEntity = generateDummyCourses()[i]
            if (courseEntity.courseId == courseId) {
                mCourse = courseEntity
            }
        }
        return mCourse
    }

    fun getModules(): List<ModuleEntity> {
        return generateDummyModules(getCourseId())
    }

    fun setCourseId(courseId: String) {
        this.courseId = courseId
    }

    fun getCourseId(): String {
        return courseId
    }
}