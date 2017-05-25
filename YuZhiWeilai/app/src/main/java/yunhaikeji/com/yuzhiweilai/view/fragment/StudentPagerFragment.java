package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.presenter.ImplPresenter;
import yunhaikeji.com.yuzhiweilai.utils.BannerImageLoader;
import yunhaikeji.com.yuzhiweilai.view.activity.MainActivity;
import yunhaikeji.com.yuzhiweilai.view.function_interface.ViewInterface;
import yunhaikeji.com.yuzhiweilai.view.my_view.CustomGridView;
import yunhaikeji.com.yuzhiweilai.view.my_view.CustomListView;

/**
 * Use:学习页面的fanggment
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class StudentPagerFragment extends Fragment implements View.OnClickListener,ViewInterface{


    @BindView(R.id.stu_pagerbanner)
    Banner stuPagerbanner;
    @BindView(R.id.stu_pager_mf_iamge)
    ImageView stuPagerMfIamge;
    @BindView(R.id.stu_pager_mf_lookall)
    RelativeLayout stuPagerMfLookall;
    @BindView(R.id.stu_pager_lv_free)
    CustomListView stuPagerLvFree;
    @BindView(R.id.stu_pager_jx_iamge)
    ImageView stuPagerJxIamge;
    @BindView(R.id.stu_pager_jxlookall)
    RelativeLayout stuPagerJxlookall;
    @BindView(R.id.stu_pager_lv_choiceness)
    CustomListView stuPagerLvChoiceness;
    @BindView(R.id.stu_pager_zj_iamge)
    ImageView stuPagerZjIamge;
    @BindView(R.id.stu_pager_jp_lookall)
    RelativeLayout stuPagerJpLookall;
    @BindView(R.id.stu_pager_lv_special)
    CustomGridView stuPagerLvSpecial;
    Unbinder unbinder;
    private MainActivity activity;
    private ClassPagerFragment cf;
    private MyPagerFragment mf;
    private FreeClassFragment fc;
    private QualityClassFragment qc;
    private SpecialClassFragment sc;
    private FragmentManager manager;
    private ImplPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_pager_layout, null);

        unbinder = ButterKnife.bind(this, view);
        //初始化fragment
        initFragment();
        initView();
        presenter = new ImplPresenter(getActivity(),this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.showListBannerToView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //获得MainActivity 对象,以及其他fragment对象
    private void initFragment(){
        activity = (MainActivity) getActivity();
        manager = getFragmentManager();

        cf = (ClassPagerFragment) manager.findFragmentByTag("cf");
        mf = (MyPagerFragment) manager.findFragmentByTag("mf");
        fc = (FreeClassFragment) manager.findFragmentByTag("fc");
        qc = (QualityClassFragment) manager.findFragmentByTag("qc");
        sc = (SpecialClassFragment) manager.findFragmentByTag("sc");
    }

    //注册点击事件
    private void initView(){
        stuPagerMfLookall.setOnClickListener(this);
        stuPagerJxlookall.setOnClickListener(this);
        stuPagerJpLookall.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stu_pager_mf_lookall:
                //跳转免费课程界面
                activity.cutFragment(manager,fc,StudentPagerFragment.this,cf,mf,qc,sc);
                break;
            case R.id.stu_pager_jxlookall:
                //跳转精品课程界面
                activity.cutFragment(manager,qc,StudentPagerFragment.this,cf,mf,fc,sc);
                break;
            case R.id.stu_pager_jp_lookall:
                //跳转精品专辑页面
                activity.cutFragment(manager,sc,StudentPagerFragment.this,cf,mf,qc,fc);
                break;

        }
    }

    /**
     * 首页轮播图展示
     * @param listBannerBean
     */
    @Override
    public void showListBanner(ListBannerBean listBannerBean) {
        ArrayList<String> list = new ArrayList<>();
        List<ListBannerBean.DataBean.BannerBean> banner = listBannerBean.getData().getBanner();
        for (int i = 0; i <banner.size() ; i++) {
            list.add(banner.get(i).getImage());
        }

        //设置图片加载器
        stuPagerbanner.setImageLoader(new BannerImageLoader());
//设置图片集合
        stuPagerbanner.setImages(list);
//banner设置方法全部调用完毕时最后调用
        stuPagerbanner.start();
    }
}
