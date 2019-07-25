package cn.tklvyou.smartapartments.ui.test;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.tklvyou.smartapartments.R;
import cn.tklvyou.smartapartments.base.BaseViewHolder;
import cn.tklvyou.smartapartments.model.Entry;

/**使用方法：复制>粘贴>改名>改代码  */
/**自定义View模板，当View比较庞大复杂(解耦效果明显)或使用次数>=2(方便重用)时建议使用
 * @author Lemon
 * @see DemoAdapter#createView
 * @use
 * <br> DemoComplexViewHolder DemoComplexViewHolder = new DemoComplexViewHolder(context, resources);
 * <br> adapter中使用:[具体参考.BaseViewAdapter(getView使用自定义View的写法)]
 * <br> convertView = DemoComplexViewHolder.createView(inflater);
 * <br> DemoComplexViewHolder.bindView(position, data);
 * <br> 或 其它类中使用:
 * <br> containerView.addView(DemoComplexViewHolder.createView(inflater));
 * <br> DemoComplexViewHolder.bindView(data);
 * <br> 然后
 * <br> DemoComplexViewHolder.setOnDataChangedListener(onDataChangedListener); data = DemoComplexViewHolder.getData();//非必需
 * <br> DemoComplexViewHolder.setOnClickListener(onClickListener);//非必需
 * <br> ...
 */
public class DemoComplexViewHolder extends BaseViewHolder<Entry<String, String>> implements OnClickListener {
	private static final String TAG = "DemoComplexViewHolder";

	public DemoComplexViewHolder(Activity context) {
		super(context, R.layout.demo_complex_view); //TODO demo_complex_view改为你所需要的layout文件
	}


	//示例代码<<<<<<<<<<<<<<<<
	public ImageView ivDemoComplexViewHead;
	public TextView tvDemoComplexViewName;
	public TextView tvDemoComplexViewNumber;
	//示例代码>>>>>>>>>>>>>>>>
	@Override
	public View createView() {
		//示例代码<<<<<<<<<<<<<<<<
		ivDemoComplexViewHead = findView(R.id.ivDemoComplexViewHead);
		tvDemoComplexViewName = findView(R.id.tvDemoComplexViewName, this);
		tvDemoComplexViewNumber = findView(R.id.tvDemoComplexViewNumber);
		//示例代码>>>>>>>>>>>>>>>>

		return super.createView();
	}


	@Override
	public void bindView(Entry<String, String> data_){
		//示例代码<<<<<<<<<<<<<<<<
		super.bindView(data_ != null ? data_ : new Entry<String, String>());

		Glide.with(context).load(data.getKey()).into(ivDemoComplexViewHead);

		tvDemoComplexViewName.setText("Name " + position);
		tvDemoComplexViewNumber.setText(data.getValue());
		//示例代码>>>>>>>>>>>>>>>>
	}


	//示例代码<<<<<<<<<<<<<<<<
	@Override
	public void onClick(View v) {
		if (data == null) {
			return;
		}
		switch (v.getId()) {
		case R.id.tvDemoComplexViewName:
			tvDemoComplexViewName.setText("New " + tvDemoComplexViewName);
			break;
		default:
			break;
		}
	}
	//示例代码>>>>>>>>>>>>>>>>


}