package yunhaikeji.com.yuzhiweilai.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.application.App;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.impl_class.ImplFunction;
import yunhaikeji.com.yuzhiweilai.model.function_interface.ModelFunctionInterface;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.view.function_interface.ViewInterface;

/**
 * Use:Presenter 实现类
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public class ImplPresenter implements PresenterInterface{
     Context context;
    SharedPreferences preferences;
    ViewInterface viewInterface;
   ModelFunctionInterface functionInterface;

    public ImplPresenter(Context context,ViewInterface viewInterface) {
        this.context=context;
        this.viewInterface = viewInterface;
        this.functionInterface = new ImplFunction(context,this);
        preferences=context.getSharedPreferences(App.COFIGNAME,Context.MODE_PRIVATE);
    }


    @Override
    public void getFirstHand(boolean b) {
        viewInterface.getFristHand(b);
    }

    @Override
    public void showFirst() {
        functionInterface.first_hand(context,preferences,ModelUtils.APPTYPE,ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick());
    }

    /**
     * 获得轮播图
     * @param listBannerBean
     */
    @Override
    public void getListBannerForModel(ListBannerBean listBannerBean) {
            viewInterface.showListBanner(listBannerBean);
    }

    /**
     * 展示到页面内
     */
    @Override
    public void showListBannerToView() {
        Log.d("Imppa,",ModelUtils.getAppKey(preferences));
            functionInterface.getList_banner(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),
                    ModelUtils.getVer_code(context));
    }

    /**
     * 获得试听列表
     * @param list
     */
    @Override
    public void getListTryClass(ArrayList<ListTryBean.DataBean.TryBean> list) {
            //新建适配器
    }

    /**
     * 展示试听列表
     */
    @Override
    public void showListTryClass() {
        functionInterface.getList_try(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick(),null,null,5,0);
    }
}
