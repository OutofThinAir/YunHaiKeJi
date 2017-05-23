package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.view.activity.MainActivity;

/**
 * Use:精品专辑列表Fragment
 * Author:陈懿鹏
 * Data:2017/5/22.
 */

public class SpecialClassFragment extends Fragment {
    @BindView(R.id.special_all_class_last)
    ImageView specialAllClassLast;
    @BindView(R.id.special_all_class_title)
    RelativeLayout specialAllClassTitle;
    @BindView(R.id.special_all_class_lv)
    ListView specialAllClassLv;
    Unbinder unbinder;
    private MainActivity activity;
    private ClassPagerFragment cf;
    private MyPagerFragment mf;
    private FreeClassFragment fc;
    private StudentPagerFragment sf;
    private QualityClassFragment qc;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_all_class_layout, null);
        unbinder = ButterKnife.bind(this, view);
        initFragment();
        specialAllClassLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.cutFragment(manager,sf,SpecialClassFragment.this,cf,mf,fc,qc);
            }
        });

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
        qc = (QualityClassFragment) manager.findFragmentByTag("qc");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
