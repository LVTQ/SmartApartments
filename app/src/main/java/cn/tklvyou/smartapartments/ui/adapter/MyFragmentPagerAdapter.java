package cn.tklvyou.smartapartments.ui.adapter;


import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.trello.rxlifecycle3.components.support.RxFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<RxFragment> data;

    public MyFragmentPagerAdapter(FragmentManager fm, List<RxFragment> data) {
        super(fm);
        this.data = data;
        Log.e("test","--- 1 ---");
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }


    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }
}
