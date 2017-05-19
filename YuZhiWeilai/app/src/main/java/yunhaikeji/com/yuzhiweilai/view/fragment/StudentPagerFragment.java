package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.view.my_view.CustomGridView;
import yunhaikeji.com.yuzhiweilai.view.my_view.CustomListView;

/**
 * Use:学习页面的fanggment
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class StudentPagerFragment extends Fragment {

    @BindView(R.id.stu_pagerbanner)
    Banner stuPagerbanner;
    @BindView(R.id.stu_pager_lv_free)
    CustomListView stuPagerLvFree;
    @BindView(R.id.stu_pager_lv_choiceness)
    CustomListView stuPagerLvChoiceness;
    @BindView(R.id.stu_pager_zj_iamge)
    ImageView stuPagerZjIamge;
    @BindView(R.id.stu_pager_lookall)
    RelativeLayout stuPagerLookall;
    @BindView(R.id.stu_pager_lv_special)
    CustomGridView stuPagerLvSpecial;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_pager_layout, null);
        unbinder = ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
