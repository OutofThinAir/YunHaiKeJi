package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.model.adapter.MyFragmentAdapter;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.view.activity.MainActivity;

/**
 * Use:免费课程列表fragment
 * Author:陈懿鹏
 * Data:2017/5/22.
 */

public class FreeClassFragment extends BaseFragment {

    @BindView(R.id.free_all_pager_last)
    ImageView freeAllPagerLast;
    @BindView(R.id.free_all_class_title)
    RelativeLayout freeAllClassTitle;
    @BindView(R.id.free_all_class_tab)
    TabLayout freeAllClassTab;
    @BindView(R.id.free_all_class_pager)
    ViewPager freeAllClassPager;
    Unbinder unbinder;

    private MainActivity activity;
    private ClassPagerFragment cf;
    private MyPagerFragment mf;
    private StudentPagerFragment sf;
    private QualityClassFragment qc;
    private SpecialClassFragment sc;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.free_all_class_layout, null);
        unbinder = ButterKnife.bind(this, view);

        initFragment();
        //返回上一页
        freeAllPagerLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               activity.cutFragment(manager,sf,cf,mf,qc,sc,FreeClassFragment.this);
            }
        });


        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //上方导航的集合
        ArrayList<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("美容");
        titles.add("美甲");
        titles.add("按摩");
        titles.add("培训");
        //fragment的集合
        ArrayList<FreeClassPagerListFragment> fragments = new ArrayList<>();
        for (int i = 0; i <titles.size() ; i++) {
            fragments.add(FreeClassPagerListFragment.newInstens(titles.get(i)));
        }

        //设置适配器,添加fragment
        MyFragmentAdapter adapter = new MyFragmentAdapter(manager,titles,fragments);
        freeAllClassTab.setTabMode(TabLayout.MODE_FIXED);


        freeAllClassTab.setupWithViewPager(freeAllClassPager);
        freeAllClassPager.setAdapter(adapter);

    }

    //初始化Activity 及相关的Fragment
    private void initFragment(){
        activity = (MainActivity) getActivity();
        manager = getFragmentManager();

        cf = (ClassPagerFragment) manager.findFragmentByTag("cf");
        mf = (MyPagerFragment) manager.findFragmentByTag("mf");
        sf = (StudentPagerFragment) manager.findFragmentByTag("sf");
        qc = (QualityClassFragment) manager.findFragmentByTag("qc");
        sc = (SpecialClassFragment) manager.findFragmentByTag("sc");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
