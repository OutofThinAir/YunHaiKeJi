package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;

/**
 * Use:精品课程诸多分类页
 * Author:陈懿鹏
 * Data:2017/5/22.
 */

public class QualityClassPagerListFragment extends Fragment {

    @BindView(R.id.free_all_class_lv_lv)
    ListView quAllClassLvLv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //实现Fragment 的复用
        Bundle bundleb = getArguments();
        String title = bundleb.getString("title");

        View view = inflater.inflate(R.layout.free_class_lv_layout, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    //生成Fragment的方法

    public static QualityClassPagerListFragment newInstens(String title) {

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        QualityClassPagerListFragment qcl = new QualityClassPagerListFragment();
        qcl.setArguments(bundle);
        return qcl;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
