package yunhaikeji.com.yuzhiweilai.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.application.App;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.bena.LoginBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ReginBean;
import yunhaikeji.com.yuzhiweilai.model.bena.SpecialClassBean;
import yunhaikeji.com.yuzhiweilai.model.bena.VerifyBean;
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


//    @Override
//    public void getFirstHand(boolean b) {
//        viewInterface.getFristHand(b);
//    }

//    @Override
//    public void showFirst() {
//        functionInterface.first_hand(context,preferences,ModelUtils.APPTYPE,ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick());
//    }

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
            //传到view
        viewInterface.showListTryClass(list);

    }

    /**
     * 展示试听列表
     */
    @Override
    public void showListTryClass(String category,int pager_size) {
        functionInterface.getList_try(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick(),null,category,pager_size,0);
    }

    /**
     * 得到精品专辑
     * @param list
     */
    @Override
    public void getListSpecial(ArrayList<SpecialClassBean.DataBean.TopicBean> list) {

        //传到view
        viewInterface.showListSpecial(list);
    }

    /**
     * 展示精品专辑
     */
    @Override
    public void showListSpecial(int pager_size) {
        functionInterface.getList_topic(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick(),null,null,pager_size,0);

    }

    /**
     * 得到注册信息
     * @param reginBean
     */
    @Override
    public void getReginBean(ReginBean reginBean) {
        //判断注册状态
        int res = reginBean.getRet();
        String info=null;

        if (res==-5){
            info="手机号位数错误";
        }else if(res==-6){
            info="手机号已经注册";
        }else if(res==-10){
            info="您输入的可能不是手机号";
        }else if(res==0){
            info="注册成功";
        }
        viewInterface.showReginInfo(info);

    }

    /**
     * 得到验证信息
     * @param verifyBean
     */
    @Override
    public void getVerifyBean(VerifyBean verifyBean) {

        //判断注册状态
        int res = verifyBean.getRet();
        String info=null;

        if (res==-4) {
            info = "系统繁忙,请稍后继续";
        }else if(res==0){
            info="注册成功";
        }
        viewInterface.showReginInfo(info);

    }

    /**
     * 注册
     */
    @Override
    public void userReginBean(String mobile,String rand,String pwd) {
        functionInterface.user_regin(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),
                ModelUtils.getVer_code(context),ModelUtils.getTick(),mobile,rand,pwd);

    }

    /**
     * 获得登录信息
     * @param bean
     */
    @Override
    public void getLoginBean(LoginBean bean) {

        int ret = bean.getRet();
        String info=null;
        if (ret==0){
            info="登录成功";
        }else if (ret==-5){
            info="手机号为注册";
        }else if (ret==-7){
            info="密码错误";
        }else if (ret==-9){
            info="密码错误次数过多账号锁定15分钟";
        }else if (ret==-10){
            info="请输入正确的手机号";
        }
        viewInterface.showLoginInfo(info);

    }

    /**
     * 登录
     * @param mobile
     * @param pwd
     */
    @Override
    public void userLogin(String mobile, String pwd) {

        functionInterface.pwd_login(context,preferences,ModelUtils.getAppKey(preferences),ModelUtils.getLocaldeviceId(context),
                ModelUtils.getVer_code(context),ModelUtils.getTick(),mobile,pwd);
    }


}
