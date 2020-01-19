package com.arioki.belajarandroidjetpackpro.ui.bookmark

import androidx.lifecycle.ViewModel
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.generateDummyCourses


class BookmarkViewModel : ViewModel() {
    fun getBookmarks(): List<CourseEntity> {
        return generateDummyCourses()
    }
}