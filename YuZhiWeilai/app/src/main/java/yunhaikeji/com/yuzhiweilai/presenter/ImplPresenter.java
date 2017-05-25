package yunhaikeji.com.yuzhiweilai.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import yunhaikeji.com.yuzhiweilai.application.App;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
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
    public void getListBannerForModel(ListBannerBean listBannerBean) {
            viewInterface.showListBanner(listBannerBean);
    }

    @Override
    public void showListBannerToView() {
            functionInterface.getList_banner(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),
                    ModelUtils.getVer_code(context));
    }
}
