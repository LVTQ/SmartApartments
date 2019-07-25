package cn.tklvyou.smartapartments.ui.test;

import android.app.Activity;
import android.view.ViewGroup;

import cn.tklvyou.smartapartments.base.BaseAdapter;


/**用户adapter
 * @author Lemon
 */
public class UserAdapter extends BaseAdapter<User, UserViewHolder> {

	public UserAdapter(Activity context) {
		super(context);
	}

	@Override
	public UserViewHolder createView(int position, ViewGroup parent) {
		return new UserViewHolder(context, parent);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

}