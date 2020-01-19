package com.arioki.belajarandroidjetpackpro.ui.bookmark


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import com.arioki.belajarandroidjetpackpro.utils.DataDummy.generateDummyCourses
import kotlinx.android.synthetic.main.fragment_bookmark.*


class BookmarkFragment : Fragment(), BookmarkFragmentCallback {
    companion object {
        fun newInstance(): BookmarkFragment {
            return BookmarkFragment()
        }
    }

    private lateinit var viewModel: BookmarkViewModel
    private lateinit var courses: List<CourseEntity>
    private lateinit var adapter: BookmarkAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(this).get(BookmarkViewModel::class.java)
            courses = viewModel.getBookmarks()
            adapter = BookmarkAdapter(it, this)
            adapter.setListCourses(generateDummyCourses())
            rv_bookmark.layoutManager = LinearLayoutManager(context)
            rv_bookmark.setHasFixedSize(true)
            rv_bookmark.adapter = adapter
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(activity)
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(
                    String.format(
                        "Segera daftar kelas %s di dicoding.com",
                        course.title
                    )
                )
                .startChooser()
        }
    }
}
