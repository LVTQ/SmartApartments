package cn.tklvyou.smartapartments.base;

import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import cn.tklvyou.smartapartments.interfaces.OnLoadListener;
import cn.tklvyou.smartapartments.interfaces.OnStopLoadListener;


/**基础http网络列表的Fragment
 * @author Lemon
 * @param <T> 数据模型(model/JavaBean)类
 * @param <VH> ViewHolder或其子类
 * @param <A> 管理LV的Adapter
 * @see #getListAsync(int)
 * @see #onHttpResponse(int, String, Exception)
 * @see
 *   <pre>
 *       基础使用：<br />
 *       extends BaseHttpRecyclerFragment 并在子类onCreateView中srlBaseHttpRecycler.autoRefresh(), 具体参考.UserRecyclerFragment
 *       <br /><br />
 *       列表数据加载及显示过程：<br />
 *       1.srlBaseHttpRecycler.autoRefresh触发刷新 <br />
 *       2.getListAsync异步获取列表数据 <br />
 *       3.onHttpResponse处理获取数据的结果 <br />
 *       4.setList把列表数据绑定到adapter <br />
 *   </pre>
 */
public abstract class BaseHttpRecyclerFragment<T, VH extends RecyclerView.ViewHolder, A extends RecyclerView.Adapter<VH>>
		extends BaseRecyclerFragment<T, VH, A>
		implements OnStopLoadListener, OnRefreshListener, OnLoadMoreListener {

	private static final String TAG = "BaseHttpRecyclerFragment";

	protected SmartRefreshLayout srlBaseHttpRecycler;

	protected abstract SmartRefreshLayout getSmartRefreshLayout();

	@Override
	public void initView() {
		super.initView();
		srlBaseHttpRecycler = getSmartRefreshLayout();

		setOnStopLoadListener(this);

		srlBaseHttpRecycler.setOnRefreshListener(this);
		srlBaseHttpRecycler.setOnLoadMoreListener(this);

	}



	@Override
	public void setAdapter(A adapter) {
		if (adapter instanceof BaseAdapter) {
			((BaseAdapter) adapter).setOnLoadListener(new OnLoadListener() {
				@Override
				public void onRefresh() {
					srlBaseHttpRecycler.autoRefresh();
				}

				@Override
				public void onLoadMore() {
					srlBaseHttpRecycler.autoLoadMore();
				}
			});
		}
		super.setAdapter(adapter);
	}


	/**
	 * @param page 用-page作为requestCode
	 */
	@Override
	public abstract void getListAsync(int page);


	/**重写后可自定义对这个事件的处理
	 * @param parent
	 * @param view
	 * @param position
	 * @param id
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}

	@Override
	public void onRefresh(RefreshLayout refreshlayout) {
		onRefresh();
	}

	@Override
	public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
		onLoadMore();
	}


	@Override
	public void onStopRefresh() {
		runUiThread(new Runnable() {

			@Override
			public void run() {
				srlBaseHttpRecycler.finishRefresh();
			}
		});
	}
	@Override
	public void onStopLoadMore(final boolean isHaveMore) {
		runUiThread(new Runnable() {

			@Override
			public void run() {
				if (isHaveMore) {
					srlBaseHttpRecycler.finishLoadMore();
				} else {
					srlBaseHttpRecycler.finishLoadMoreWithNoMoreData();
				}
			}
		});
	}


	/**处理结果
	 * @param page
	 * @param list
	 * @param e
	 */
	public void onResponse(int page, List<T> list, Exception e) {
		if ((list == null || list.isEmpty()) && e != null) {
			onLoadFailed(page, e);
		} else {
			onLoadSucceed(page, list);
		}
	}

}