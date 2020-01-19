package com.arioki.belajarandroidjetpackpro.ui.academy

import androidx.lifecycle.ViewModel
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.generateDummyCourses


class AcademyViewModel : ViewModel() {
    fun getCourses(): List<CourseEntity> {
        return generateDummyCourses()
    }
}