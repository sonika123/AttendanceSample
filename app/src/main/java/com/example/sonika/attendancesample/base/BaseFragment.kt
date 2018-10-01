package com.example.sonika.attendancesample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sonika.attendancesample.LoginFragment
import com.example.sonika.attendancesample.R
import java.util.zip.Inflater

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