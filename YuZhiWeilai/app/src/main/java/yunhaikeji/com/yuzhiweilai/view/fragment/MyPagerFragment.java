package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.view.activity.LoginActivity;

/**
 * Use:我的页面的fragment
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class MyPagerFragment extends BaseFragment {
    @BindView(R.id.my_pager_title)
    RelativeLayout myPagerTitle;

    @BindView(R.id.my_pager_himage)
    ImageButton myPagerHimage;

    @BindView(R.id.my_pager_uname)
    TextView myPagerUname;

    @BindView(R.id.my_pager_vipdengj)
    TextView myPagerVipdengj;

    @BindView(R.id.my_pager_mydown)
    RelativeLayout myPagerMydown;

    @BindView(R.id.my_pager_mycollect)
    RelativeLayout myPagerMycollect;


    @BindView(R.id.my_pager_myaccount)
    RelativeLayout myPagerMyaccount;


    @BindView(R.id.my_pager_usenum)
    TextView myPagerUsenum;

    @BindView(R.id.my_pager_mychase)
    RelativeLayout myPagerMychase;

    @BindView(R.id.my_pager_mynews)
    RelativeLayout myPagerMynews;

    @BindView(R.id.vip)
    ImageView vip;

    @BindView(R.id.my_pager_myvip)
    RelativeLayout myPagerMyvip;


    @BindView(R.id.my_pager_mysetting)
    RelativeLayout myPagerMysetting;


    @BindView(R.id.my_pager_kphone)
    TextView myPagerKphone;

    @BindView(R.id.my_pager_myphone)
    RelativeLayout myPagerMyphone;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_pager_layout, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.my_pager_himage, R.id.my_pager_mydown, R.id.my_pager_mycollect, R.id.my_pager_myaccount, R.id.my_pager_mychase, R.id.my_pager_mynews, R.id.my_pager_myvip, R.id.my_pager_mysetting, R.id.my_pager_myphone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_pager_himage:
                //点击头像跳转登录界面
                Intent intent =new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.my_pager_mydown:
                break;
            case R.id.my_pager_mycollect:
                break;
            case R.id.my_pager_myaccount:
                break;
            case R.id.my_pager_mychase:
                break;
            case R.id.my_pager_mynews:
                break;
            case R.id.my_pager_myvip:
                break;
            case R.id.my_pager_mysetting:
                break;
            case R.id.my_pager_myphone:
                break;
        }
    }
}
