package com.arioki.belajarandroidjetpackpro

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.belajarandroidjetpackpro.bookmark.BookmarkFragmentCallback
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import com.arioki.belajarandroidjetpackpro.detail.DetailCourseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class BookmarkAdapter(private val activity: Activity, private val callback: BookmarkFragmentCallback) :
    RecyclerView.Adapter<BookmarkAdapter.AcademyViewHolder>() {
    private val courses: ArrayList<CourseEntity> = ArrayList()

    fun setListCourses(courses: List<CourseEntity>) {
        this.courses.clear()
        this.courses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.items_bookmark, parent, false)
        return AcademyViewHolder(view)
    }

    override fun getItemCount(): Int = courses.size

    override fun onBindViewHolder(holder: AcademyViewHolder, position: Int) {
        val course = courses[position]
        holder.tvTitle.text = course.title
        holder.tvDate.text = String.format("Deadline %s", course.deadline)
        holder.tvDescription.text = course.description
        holder.itemView.setOnClickListener {
            val intent = Intent(activity, DetailCourseActivity::class.java)
            intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
            activity.startActivity(intent)
        }
        holder.imgShare.setOnClickListener {
            callback.onShareClick(courses[holder.adapterPosition])
        }
        Glide.with(holder.itemView.context)
            .load(course.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(holder.imgPoster);
    }

    class AcademyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvDate: TextView = itemView.findViewById(R.id.tv_item_date)
        val imgShare: ImageButton = itemView.findViewById(R.id.img_share)
        val imgPoster: ImageView = itemView.findViewById(R.id.img_poster)
    }

}
