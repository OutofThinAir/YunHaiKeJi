package yunhaikeji.com.yuzhiweilai.presenter;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.bena.LoginBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ReginBean;
import yunhaikeji.com.yuzhiweilai.model.bena.SpecialClassBean;
import yunhaikeji.com.yuzhiweilai.model.bena.VerifyBean;

/**
 * Use:Presenter 层功能接口
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public interface PresenterInterface {


    /**
     * 拿到握手成功的标识
     * @param b
     */
   // void getFirstHand(boolean b);


    /**
     * 将标识传到view
     */
//void showFirst();
    /**
     * 从Model层获取轮播图
     * @param listBannerBean
     */
    void getListBannerForModel(ListBannerBean listBannerBean);

    /**
     * 向V层展示数据
     */
    void showListBannerToView();

    /**
     * 获得试听列表
     * @param list
     */
    void getListTryClass(ArrayList<ListTryBean.DataBean.TryBean> list);

    /**
     * 展示试听列表
     */
    void showListTryClass(String category,int pager_size);

    /**
     *
     * @param list
     */
    void getListSpecial(ArrayList<SpecialClassBean.DataBean.TopicBean> list);

    /**
     * 展示专辑列表
     */
    void showListSpecial(int pager_size);

    /**
     * 获得注册的返回信息
     * @param reginBean
     */
    void getReginBean(ReginBean reginBean);

    /**
     * 获得验证的信息
     * @param verifyBean
     */
    void getVerifyBean(VerifyBean verifyBean);

    /**
     * 注册
     */
    void userReginBean(String mobile,String rand,String pwd);

    /**
     * 获得登录信息
     * @param bean
     */
    void getLoginBean(LoginBean bean);

    /**
     * 登录
     * @param mobile
     * @param pwd
     */

    void userLogin(String mobile,String pwd);


}
