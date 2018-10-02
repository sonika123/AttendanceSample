package com.eightsquare.attendance.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eightsquare.attendance.R

abstract class BaseFragment : Fragment() {

    abstract var latoutInt : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(latoutInt, container, false)
        return view
    }

    fun openFragment(fragment : Fragment)
    {
        val fragmentManager  = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, fragment)
        fragmentTransaction?.commit()
    }
}