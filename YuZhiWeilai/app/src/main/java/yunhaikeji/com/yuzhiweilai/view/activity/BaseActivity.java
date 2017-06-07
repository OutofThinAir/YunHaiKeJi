package yunhaikeji.com.yuzhiweilai.view.activity;

import android.app.Activity;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.bena.SpecialClassBean;
import yunhaikeji.com.yuzhiweilai.view.function_interface.ViewInterface;

/**
 * Use:Activity超类
 * Author:陈懿鹏
 * Data:2017/6/2.
 */

public class BaseActivity extends Activity implements ViewInterface{
    @Override
    public void showListBanner(ListBannerBean listBannerBean) {

    }

    @Override
    public void showListTryClass(ArrayList<ListTryBean.DataBean.TryBean> list) {

    }

    @Override
    public void showListSpecial(ArrayList<SpecialClassBean.DataBean.TopicBean> list) {

    }

    @Override
    public void showReginInfo(String info) {

    }

    @Override
    public void showLoginInfo(String info) {

    }
}
