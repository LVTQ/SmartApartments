package cn.tklvyou.smartapartments.ui.test

import android.os.Handler

import cn.tklvyou.smartapartments.R
import cn.tklvyou.smartapartments.base.BaseHttpRecyclerActivity
import cn.tklvyou.smartapartments.base.NullPresenter
import cn.tklvyou.smartapartments.interfaces.AdapterCallBack
import kotlinx.android.synthetic.main.demo_http_recycler_activity.*


/** 使用方法：复制>粘贴>改名>改代码  */

/**用户列表界面Activity示例
 * @author Lemon
 * @warn 复制到其它工程内使用时务必修改import R文件路径为所在应用包名
 */
class DemoHttpRecyclerActivity : BaseHttpRecyclerActivity<NullPresenter, User, UserViewHolder, UserAdapter>() {

    override fun getActivityLayoutID(): Int {
        return R.layout.demo_http_recycler_activity
    }


    override fun initPresenter(): NullPresenter {
        return NullPresenter()
    }

    override fun initView() {
        initSmartRefreshLayout(smartRefreshLayout)
        initRecyclerView(recyclerView)
        srlBaseHttpRecycler.autoRefresh()
    }

    override fun getListAsync(page: Int) {

        //实际使用时用这个，需要配置服务器地址		HttpRequest.getUserList(range, page, -page, this);

        //仅测试用<<<<<<<<<<<
        Handler().postDelayed({
            setResponse(page,TestUtil.getUserList(page, 10),null)
        }, 1000)
        //仅测试用>>>>>>>>>>>>
    }


    override fun setList(list: MutableList<User>?) {
        setList(object : AdapterCallBack<UserAdapter> {

            override fun createAdapter(): UserAdapter {
                return UserAdapter(this@DemoHttpRecyclerActivity)
            }

            override fun refreshAdapter() {
                adapter.refresh(list)
            }
        })
    }

}