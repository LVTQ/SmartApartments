package cn.tklvyou.smartapartments.ui.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import cn.tklvyou.smartapartments.R
import cn.tklvyou.smartapartments.base.BaseActivity
import cn.tklvyou.smartapartments.base.NullContract
import cn.tklvyou.smartapartments.base.NullPresenter
import cn.tklvyou.smartapartments.ui.adapter.MyFragmentPagerAdapter
import com.trello.rxlifecycle3.components.support.RxFragment
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : BaseActivity<NullPresenter>(), NullContract.View, ViewPager.OnPageChangeListener {

    override fun initView(savedInstanceState: Bundle?) {
        val loginFragment = LoginFragment()
        val registerFragment = RegisterFragment()
        val data = ArrayList<RxFragment>()
        data.add(loginFragment)
        data.add(registerFragment)
        val adapter = MyFragmentPagerAdapter(supportFragmentManager, data)
        loginViewpager.adapter = adapter
        loginViewpager.addOnPageChangeListener(this@AccountActivity)
    }

    override fun getActivityLayoutID(): Int {
        return R.layout.activity_account
    }

    override fun initPresenter(): NullPresenter {
        return NullPresenter()
    }


    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

    override fun onPageSelected(p0: Int) {

    }

}