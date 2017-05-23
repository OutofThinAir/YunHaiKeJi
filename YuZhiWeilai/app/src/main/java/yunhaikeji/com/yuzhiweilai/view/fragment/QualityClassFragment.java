package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.graphics.drawable.BitmapDrawable;
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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.view.activity.MainActivity;

/**
 * Use:精品课程列表
 * Author:陈懿鹏
 * Data:2017/5/22.
 */

public class QualityClassFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.qualtiy_all_pager_last)
    ImageView qualtiyAllPagerLast;
    @BindView(R.id.quality_all_class_sort)
    LinearLayout qualityAllClassSort;
    @BindView(R.id.quality_all_class_title)
    RelativeLayout qualityAllClassTitle;
    @BindView(R.id.quality_all_class_tab)
    TabLayout qualityAllClassTab;
    @BindView(R.id.quality_all_class_pager)
    ViewPager qualityAllClassPager;

    @BindView(R.id.quality_all_class_text)
    TextView textView;
    Unbinder unbinder;

    private MainActivity activity;
    private ClassPagerFragment cf;
    private MyPagerFragment mf;
    private FreeClassFragment fc;
    private StudentPagerFragment sf;
    private SpecialClassFragment sc;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quality_all_class_layout, null);
        unbinder = ButterKnife.bind(this, view);

        initFragment();
        qualtiyAllPagerLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.cutFragment(manager,sf,QualityClassFragment.this,cf,mf,fc,sc);
            }
        });

        //注册监听
        qualityAllClassSort.setOnClickListener(this);

        return view;
    }

    //获得MainActivity 对象,以及其他fragment对象
    private void initFragment(){
        activity = (MainActivity) getActivity();
        manager = getFragmentManager();

        cf = (ClassPagerFragment) manager.findFragmentByTag("cf");
        mf = (MyPagerFragment) manager.findFragmentByTag("mf");
        fc = (FreeClassFragment) manager.findFragmentByTag("fc");
        sf = (StudentPagerFragment) manager.findFragmentByTag("sf");
        sc = (SpecialClassFragment) manager.findFragmentByTag("sc");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.quality_all_class_sort:
                //弹出popupwindow
                //实例化一个popupwinndows

                //视图
                View view =View.inflate(getActivity(),R.layout.popup_layout,null);
                int width=334;
                int height=214;
                PopupWindow pop = new PopupWindow(view,width,height,true);
                //设置popupWindown获取焦点 这样输入框才能获取到焦点  默认为false
                pop.setFocusable(true);
                //设置窗体外面部分可以触摸 如果true 触摸外面的时候将会隐藏窗体
                pop.setOutsideTouchable(true);

                //上面的方法要结合着 设置背景去用 new BitmapDrawable()意思是一个空的背景
                /**
                 * 两个方法结合使用 可以使点击周围的时候 窗体消失 ;点击返回键的时候窗体消失 而不是直接作用在activity上
                 */
                pop.setBackgroundDrawable(new BitmapDrawable());

                //淡出弹窗
                pop.showAsDropDown(qualityAllClassSort,20,20);

                break;
        }
    }
}
