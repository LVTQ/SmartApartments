package cn.tklvyou.smartapartments.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import cn.tklvyou.smartapartments.R
import cn.tklvyou.smartapartments.base.BaseBottomTabActivity
import cn.tklvyou.smartapartments.base.NullPresenter
import cn.tklvyou.smartapartments.ui.account.LoginFragment
import cn.tklvyou.smartapartments.ui.account.RegisterFragment
import com.trello.rxlifecycle3.components.support.RxFragment
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : BaseBottomTabActivity<NullPresenter>(){
    override fun getFragments(): MutableList<RxFragment> {
        return mFragments!!
    }

    override fun getFragmentContainerResId(): Int {
        return R.id.mainContainer
    }

    override fun initPresenter(): NullPresenter {
        return NullPresenter()
    }


    override fun getActivityLayoutID(): Int {
        return R.layout.activity_main
    }

    private var mFragments:MutableList<RxFragment>? =  null
    override fun initView(savedInstanceState: Bundle?) {

        mFragments = ArrayList()
        mFragments!!.add(LoginFragment())
        mFragments!!.add(RegisterFragment())
        mFragments!!.add(LoginFragment())
        mFragments!!.add(RegisterFragment())

        bottomNavigationView.enableAnimation(false)
        bottomNavigationView.enableShiftingMode(false)
        bottomNavigationView.enableItemShiftingMode(false)

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.navigation_home -> selectFragment(0)
                R.id.navigation_camera -> selectFragment(1)
                R.id.navigation_service -> selectFragment(2)
                R.id.navigation_mine -> selectFragment(3)
            }
            return@setOnNavigationItemSelectedListener true
        }

        selectFragment(0)
    }

}
