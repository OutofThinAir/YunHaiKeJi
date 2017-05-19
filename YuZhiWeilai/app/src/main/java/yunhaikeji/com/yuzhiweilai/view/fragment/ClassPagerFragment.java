package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;

/**
 * Use:课程页面fragment
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class ClassPagerFragment extends Fragment {
    @BindView(R.id.class_pager_title)
    RelativeLayout classPagerTitle;
    @BindView(R.id.class_pager_lv)
    ListView classPagerLv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.class_pager_layout, null);

        unbinder = ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
