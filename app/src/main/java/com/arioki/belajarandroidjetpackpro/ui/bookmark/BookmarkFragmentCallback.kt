package com.arioki.belajarandroidjetpackpro.ui.bookmark

import com.arioki.belajarandroidjetpackpro.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
