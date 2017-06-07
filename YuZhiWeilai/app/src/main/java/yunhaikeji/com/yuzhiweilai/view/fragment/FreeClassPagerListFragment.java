package yunhaikeji.com.yuzhiweilai.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yunhaikeji.com.yuzhiweilai.R;
import yunhaikeji.com.yuzhiweilai.model.adapter.ListTryClassAdepter;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.presenter.ImplPresenter;

/**
 * Use:免费课程诸多分类页
 * Author:陈懿鹏
 * Data:2017/5/22.
 */

public class FreeClassPagerListFragment extends BaseFragment {

    @BindView(R.id.free_all_class_lv_lv)
    ListView freeAllClassLvLv;
    Unbinder unbinder;
    @BindView(R.id.text)
    TextView text;
    private ImplPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.free_class_lv_layout, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //实现Fragment 的复用
        Bundle bundleb = getArguments();
        String title = bundleb.getString("title");
        //实例化p层
        presenter = new ImplPresenter(getActivity(),this);
        if (title.equals("精选")){
            text.setText("精选");
            presenter.showListTryClass("",10);
        }else if (title.equals("美容")){
            text.setText("美容");
            presenter.showListTryClass("",10);
        }else if (title.equals("美甲")){
            text.setText("美甲");
            presenter.showListTryClass("",10);
        }else if (title.equals("按摩")){
            text.setText("按摩");
            presenter.showListTryClass("",10);
        }else if (title.equals("培训")){
            text.setText("培训");
            presenter.showListTryClass("",10);
        }
    }

    //生成Fragment的方法

    public static FreeClassPagerListFragment newInstens(String title) {

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        FreeClassPagerListFragment fcl = new FreeClassPagerListFragment();
        fcl.setArguments(bundle);
        return fcl;
    }


    @Override
    public void showListTryClass(ArrayList<ListTryBean.DataBean.TryBean> list) {
        super.showListTryClass(list);
        ListTryClassAdepter adepter =new ListTryClassAdepter(getActivity(),list);
        freeAllClassLvLv.setAdapter(adepter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
