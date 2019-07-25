package cn.tklvyou.smartapartments.ui.account

import android.content.Intent
import android.os.CountDownTimer
import android.text.TextUtils
import android.util.Log
import cn.tklvyou.smartapartments.R
import cn.tklvyou.smartapartments.base.BaseFragment
import cn.tklvyou.smartapartments.ui.main.MainActivity
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import kotlinx.android.synthetic.main.login_view.*

class LoginFragment : BaseFragment<AccountLoginPresenter>(), AccountContract.LoginView {
    override fun lazyData() {
        ToastUtils.showShort("懒加载数据")
        LogUtils.e("懒加载数据 --- 1")
    }

    override fun onAutoRefresh() {
        super.onAutoRefresh()
        ToastUtils.showShort("自动刷新数据")
    }

    override fun loginSuccess(msg: String?) {
        ToastUtils.showShort(msg)
        startActivity(Intent(context, MainActivity::class.java))
    }

    override fun loginError(msg: String?) {
        ToastUtils.showShort(msg)
    }

    override fun initView() {


        Log.e("test", "initing...")
//        val timeCount = TimeCount(60000, 1000)

        btnGetCode.setOnClickListener {
            //            timeCount.start()
        }

        btnLogin.setOnClickListener {
            val name = etName.text.toString().trim()
            val password = etPassword.text.toString().trim()
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                mPresenter!!.login(name, password)
            } else {
                ToastUtils.showShort("请输入正确的用户和密码")
            }
        }
    }

    override fun initPresenter(): AccountLoginPresenter {
        return AccountLoginPresenter()
    }

    override fun getFragmentLayoutID(): Int {
        return R.layout.login_view
    }


//    internal inner class TimeCount(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {
//
//        override fun onTick(millisUntilFinished: Long) {
//            btnGetCode.background = activity!!.resources.getDrawable(R.drawable.gray_tv_bg)
//            btnGetCode.isClickable = false
//            btnGetCode.text = "${millisUntilFinished / 1000}秒后可重新发送"
//        }
//
//        override fun onFinish() {
//            btnGetCode.text = "重新获取验证码"
//            btnGetCode.isClickable = true
//            btnGetCode.background = activity!!.resources.getDrawable(R.drawable.yellow_tv_bg)
//
//        }
//    }

}