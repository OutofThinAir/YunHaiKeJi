package yunhaikeji.com.yuzhiweilai.model.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.view.fragment.FreeClassPagerListFragment;

/**
 * Use:viewPagerFragment适配器
 * Author:陈懿鹏
 * Data:2017/6/1.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter{
    ArrayList<String> titles;
    ArrayList<FreeClassPagerListFragment> fragments;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<String> titles, ArrayList<FreeClassPagerListFragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
