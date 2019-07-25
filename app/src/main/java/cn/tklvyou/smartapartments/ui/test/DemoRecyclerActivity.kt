package cn.tklvyou.smartapartments.ui.test

import java.util.ArrayList

import cn.tklvyou.smartapartments.R
import cn.tklvyou.smartapartments.base.BaseRecyclerActivity
import cn.tklvyou.smartapartments.base.NullPresenter
import cn.tklvyou.smartapartments.interfaces.AdapterCallBack
import cn.tklvyou.smartapartments.model.Entry
import kotlinx.android.synthetic.main.demo_recycler_activity.*


/**
 * 使用方法：复制>粘贴>改名>改代码
 */

/**RecyclerView Activity示例
 * @author Lemon
 */
class DemoRecyclerActivity : BaseRecyclerActivity<NullPresenter, Entry<String, String>, DemoComplexViewHolder, DemoComplexAdapter>() {

    override fun initView() {//必须在onCreate方法内调用
        initRecyclerView(recyclerView)
//        		initCache(this);//初始化缓存，Entry<String, String>替换成不带类型的类才可使用，原因看 .CacheCallBack
        onRefresh()
    }

    override fun initPresenter(): NullPresenter {
        return NullPresenter()
    }

    override fun getActivityLayoutID(): Int {
        return R.layout.demo_recycler_activity
    }


    override fun setList(list: List<Entry<String, String>>) {
        //示例代码<<<<<<<<<<<<<<<
        setList(object : AdapterCallBack<DemoComplexAdapter> {

            override fun createAdapter(): DemoComplexAdapter {
                return DemoComplexAdapter(this@DemoRecyclerActivity)
            }

            override fun refreshAdapter() {
                adapter.refresh(list)
            }
        })
        //示例代码>>>>>>>>>>>>>>>
    }

    override fun getListAsync(page: Int) {

        val list = ArrayList<Entry<String, String>>()
        for (i in 0..5) {
            list.add(Entry(getPictureUrl(i + 6 * page), "联系人" + i + 6 * page))
        }

        onLoadSucceed(page, list)
    }

    /**获取图片地址，仅供测试用
     * @param userId
     * @return
     */
    private fun getPictureUrl(userId: Int): String {
        return (userId % 6).toString() + ""
    }

}