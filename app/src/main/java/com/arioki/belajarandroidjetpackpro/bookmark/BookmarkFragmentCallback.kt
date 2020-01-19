package com.arioki.belajarandroidjetpackpro.bookmark

import com.arioki.belajarandroidjetpackpro.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
