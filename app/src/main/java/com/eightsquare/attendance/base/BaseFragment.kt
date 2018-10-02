package com.eightsquare.attendance.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife


abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(layoutId, container, false)
        ButterKnife.bind(this, view)
        return view
    }
    fun openFragmentNoHistory(fragment: Fragment) {
        (activity as BaseActivity).openFragmentNoHistory(fragment)
    }

    fun openNoHistoryFragment(fragment: Fragment) {
        (activity as BaseActivity).openNoHistoryFragment(fragment)
    }


    fun openFragment(fragment: Fragment) {
        (activity as BaseActivity).openFragment(fragment)
    }

    fun addFragment(fragment: Fragment) {
        (activity as BaseActivity).addFragment(fragment)
    }

}