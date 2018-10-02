package com.eightsquare.attendance.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import butterknife.ButterKnife
import com.eightsquare.attendance.R
import com.scottyab.rootbeer.RootBeer

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutResourceId: Int
    var mContext: Context? = null
    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initOnCreate()
    }

    private fun initOnCreate() {
        setContentView(layoutResourceId)
        mContext = this@BaseActivity
        ButterKnife.bind(this)
        //check root
        checkRootPhone()

        //initialize view
        initView()
    }

    /**
     * check device root
     */
    private fun checkRootPhone() {
        if (RootBeer(mContext).isRootedWithoutBusyBoxCheck)
            finish()
    }

    fun openFragment(fragment: Fragment, cleanStack: Boolean = false, addToBackStack: Boolean = true) {
        val ft = supportFragmentManager
                .beginTransaction()
        if (cleanStack)
            clearBackStack()
        ft.replace(R.id.container,
                fragment)
        if (addToBackStack)
            ft.addToBackStack(null)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commitAllowingStateLoss()
    }

    fun addFragment(fragment: Fragment, cleanStack: Boolean = false, addToBackStack: Boolean = true) {
        val ft = supportFragmentManager.beginTransaction()
        if (cleanStack)
            clearBackStack()
        ft.add(R.id.container, fragment)
        if (addToBackStack)
            ft.addToBackStack(null)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commitAllowingStateLoss()
    }

    fun clearChildBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    fun clearTopFragment() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else
            finish()
    }

    fun openFragmentNoHistory(fragment: Fragment) {
        openFragment(fragment, cleanStack = true, addToBackStack = false)
    }

    fun openNoHistoryFragment(fragment: Fragment) {
        openFragment(fragment, cleanStack = false, addToBackStack = false)
    }


}