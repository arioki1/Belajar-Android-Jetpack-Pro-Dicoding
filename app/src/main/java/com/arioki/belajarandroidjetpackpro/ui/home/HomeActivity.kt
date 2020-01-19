package com.arioki.belajarandroidjetpackpro.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.ui.academy.AcademyFragment
import com.arioki.belajarandroidjetpackpro.ui.bookmark.BookmarkFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    companion object{
        private const val SELECTED_MENU = "selected_menu"
    }
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> fragment = AcademyFragment()
                R.id.action_bookmark -> fragment = BookmarkFragment()
            }
            fragment?.let {
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()
            }
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            nav_view.selectedItemId = R.id.action_home;
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(SELECTED_MENU, nav_view.selectedItemId);
    }
}
