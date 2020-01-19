package com.arioki.belajarandroidjetpackpro

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.belajarandroidjetpackpro.data.CourseEntity
import com.arioki.belajarandroidjetpackpro.detail.DetailCourseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class AcademyAdapter(private val activity: Activity) :
    RecyclerView.Adapter<AcademyAdapter.AcademyViewHolder>() {
    private val mCourses: MutableList<CourseEntity> = ArrayList()

    fun getListCourses() = mCourses
    fun setListCourses(listCourses: List<CourseEntity>) {
        this.mCourses.clear()
        this.mCourses.addAll(listCourses)
    }

    override fun getItemCount(): Int = mCourses.size
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AcademyAdapter.AcademyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.items_academy, parent, false)
        return AcademyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AcademyAdapter.AcademyViewHolder, position: Int) {
        holder.tvTitle.text = mCourses[position].title
        holder.tvDescription.text = mCourses[position].description
        holder.tvDate.text = String.format("Deadline %s", mCourses[position].deadline)
        holder.itemView.setOnClickListener {
            val intent = Intent(activity,DetailCourseActivity::class.java)
            intent.putExtra(DetailCourseActivity.EXTRA_COURSE, mCourses[position].courseId);
            activity.startActivity(intent);
        }
        Glide.with(holder.itemView.context)
            .load(mCourses[position].imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(holder.imgPoster)
    }

    class AcademyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvDescription: TextView = itemView.findViewById(R.id.img_poster)
        var tvDate: TextView = itemView.findViewById(R.id.tv_item_description)
        var imgPoster: ImageView = itemView.findViewById(R.id.tv_item_date)
    }
}